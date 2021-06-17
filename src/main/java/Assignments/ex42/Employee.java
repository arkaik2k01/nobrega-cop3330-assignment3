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


import java.util.ArrayList;

public class Employee
{
    //Holds an arrayList of employee type, each having a lastName, firstName, salary
    ArrayList<Person> employee = new ArrayList<>();

    //Method will separate CSV into three different strings
    public String[] processInput(String input)
    {
        String name, lastName;
        double salary;

        //Separate strings and add to a string array
        String[] inputSeparated = new String[3];
        int startOfString = 0;
        int posAtArr = 0;

        //Algorithm
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ',' || i == input.length()-1) {
                inputSeparated[posAtArr] = input.substring(startOfString, i);
                startOfString = i+1;
                posAtArr++;
            }
        }

        return inputSeparated;
    }

    //createPerson(), Create a person with those three strings
    public Person createPerson(String name, String lastName, double salary)
    {
        return new Person(name, lastName, salary);
    }

    //Add person to list
    public void addPerson(Person newPerson)
    {
        employee.add(newPerson);
    }

    //getPerson(), Sends information about the name and salary
    public Person getPerson(int i)
    {
        return employee.get(i);
    }

    public ArrayList<Person> getEmployee()
    {
        return employee;
    }
}
