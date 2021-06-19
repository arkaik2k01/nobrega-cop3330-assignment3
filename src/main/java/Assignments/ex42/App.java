package Assignments.ex42;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Miguel Nobrega
 */

/*
Exercise 42 - Parsing a Data File
Sometimes data comes in as a structured format that you have to break down and turn into records so you can process them. CSV, or comma-separated values, is a common standard for doing this.

Construct a program that reads in the following data file (you will need to create this data file yourself; name it `exercise42_input.txt`):

Ling,Mai,55900
Johnson,Jim,56500
Jones,Aaron,46000
Jones,Chris,34500
Swift,Geoffrey,14200
Xiong,Fong,65000
Zarnecki,Sabrina,51500
Process the records and display the results formatted as a table, evenly spaced, as shown in the example output.

Example Output
Last      First     Salary
--------------------------
Ling      Mai       55900
Johnson   Jim       56500
Jones     Aaron     46000
Jones     Chris     34500
Swift     Geoffrey  14200
Xiong     Fong      65000
Zarnecki  Sabrina   51500

Constraints
Write your own code to parse the data. Don't use a CSV parser.
Challenges
Make each column one space longer than the longest value in the column.
Format the salary as currency with dollar signs and commas.
Sort the results by salary from highest to lowest.
Rework your program to use a CSV parsing library and compare the results.
*/

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class App
{
    public static String[] input = new String[7];

    public static void main(String[] args)
    {
        App prog = new App();
        Employee employee = new Employee();

        //Build reader and read input
        prog.getInput();
        //Process input through Employee class
        //Once processed, add to employeeList
        prog.processInput(employee);
        //After its done, print names and format table
        prog.sendOutput(employee);
    }

    private void sendOutput(Employee employee)
    {
        int size = employee.getEmployee().size();
        System.out.printf("%-9s %-9s %10s%n", "Last", "First", "Salary");
        System.out.println("------------------------------");
        for (int i = 0; i < size; i++) {
            Person actual = employee.getPerson(i);
            System.out.printf("%-9s %-9s $%9.2f%n", actual.getLastName(), actual.getName(), actual.getSalary());
        }
    }

    private void processInput(Employee employee)
    {
        for (String s : input) {
            String[] personSeparated = employee.processInput(s);
            try {
                Person newPerson = employee.createPerson(personSeparated[1], personSeparated[0],
                        Double.parseDouble(personSeparated[2]));
                employee.addPerson(newPerson);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void getInput()
    {
        try {
            Scanner in = new Scanner(new File("./input/exercise42_input.txt"));
            //In a while loop, read input and add to array
            int i = 0;
            while (in.hasNextLine()) {
                input[i] = in.nextLine();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
