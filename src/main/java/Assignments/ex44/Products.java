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

import com.google.gson.annotations.SerializedName;

public class Products
{
    @SerializedName("name")
    private String name;
    @SerializedName("price")
    private double price;
    @SerializedName("quantity")
    private int quantity;

    //constructor
    public Products(String name, double price, int quantity)
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    //Send product as output
    public String printProduct()
    {
        return "Name: " + getName() + "\nPrice: " + getPrice() + "\nQuantity: " + getQuantity();
    }

    public boolean equals(String name)
    {
        return name.equalsIgnoreCase(getName());
    }

    //getter & setter
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
}
