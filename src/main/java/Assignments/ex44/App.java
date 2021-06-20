package Assignments.ex44;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Miguel Nobrega
 */

/*
Exercise 44 - Product Search
Pulling data from a file into a complex data structure makes parsing much simpler. Many programming languages support the JSON format,
a popular way of representing data.

Create a program that takes a product name as input and retrieves the current price and quantity for that product.
The product data is in a data file in the JSON format  and looks like this (you will create this file as `exercise44_input.json`):

{
    "products" : [
        {"name": "Widget", "price": 25.00, "quantity": 5 },
        {"name": "Thing", "price": 15.00, "quantity": 5 },
        {"name": "Doodad", "price": 5.00, "quantity": 10 }
    ]
}
Print out the product name, price, and quantity if the product is found.
If no product matches the search, state that no product was found and start over.

Example Output
What is the product name? iPad
Sorry, that product was not found in our inventory.
What is the product name? Galaxy
Sorry, that product was not found in our inventory.
What is the product name? Thing
Name: Thing
Price: 15.00
Quantity: 5

Constraints
The file is in the JSON format. Use a JSON parser to pull the values out of the file (e.g. https://github.com/google/gson (Links to an external site.)).
If no record is found, prompt again.
Challenges
Ensure that the product search is case insensitive.
When a product is not found, ask if the product should be added. If yes, ask for the price and the quantity, and save it in the JSON file. Ensure the newly added product is immediately available for searching without restarting the program.
*/

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class App
{
    static Boolean done = true;
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args)
    {
        App prog = new App();

        //Read from json file into ArrayList
        JsonObject file = prog.getJsonFile();
        assert file != null;
        ArrayList<Products> list = prog.readGSON(file);

        while (done) {
            //Ask user for name of input
            String input = prog.getInput();
            //Check if available in arrayList
            for(int i = 0; i < list.size(); i++)
            {
                boolean contained = list.get(i).equals(input);
                //Send output
                prog.isContained(contained, list, i);
            }
        }
    }

    private void isContained (Boolean bool, ArrayList<Products> list, int i) {
        if(bool)
        {
            list.get(i).printProduct();
            done = false;
        }
    }

    private JsonObject getJsonFile()
    {
        try {
            return JsonParser.parseReader(new FileReader("./input/exercise44_input.json")).getAsJsonObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String getInput()
    {
        System.out.print("What is the name of your product? ");
        return in.nextLine();
    }

    private ArrayList<Products> readGSON(JsonObject jsonFile)
    {
        JsonArray arr = jsonFile.getAsJsonArray("products");
        ArrayList<Products> list = new ArrayList<>();
        for(int i = 0; i < arr.size(); i++) {
            JsonObject cur = (JsonObject) arr.get(i);
            String name = String.valueOf(cur.get("name"));
            double price = Double.parseDouble(String.valueOf(cur.get("price")));
            int quan = Integer.parseInt(String.valueOf(cur.get("quantity")));
            Products prod = createProduct(name, price, quan);
            list.add(prod);
        }
        return list;
    }

    private Products createProduct(String name, double price, int quan) {
        return new Products(name, price, quan);
    }

}
