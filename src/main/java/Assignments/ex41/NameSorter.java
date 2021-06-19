package Assignments.ex41;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Miguel Nobrega
 */

/*
Exercise 41 - Name Sorter
Alphabetizing the contents of a file, or sorting its contents, is a great way to get comfortable manipulating
a file in your program.

Create a program that reads in the following list of names from a file called `exercise41_input.txt`
and sorts the list alphabetically:
Ling, Mai
Johnson, Jim
Zarnecki, Sabrina
Jones, Chris
Jones, Aaron
Swift, Geoffrey
Xiong, Fong
Then print the sorted list to a file called `exercise41_output.txt` that looks like the following example output.

Example Output
Total of 7 names
-----------------
Johnson, Jim
Jones, Aaron
Jones, Chris
Ling, Mai
Swift, Geoffrey
Xiong, Fong
Zarnecki, Sabrina

Constraint
Don't hard-code the number of names.
Challenges
Implement this program by reading in the names from the user, one at a time, and printing out the sorted results to a file.
Use the program to sort data from a large data set (e.g. census data) and use a profiler to analyze its performance.
*/


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class NameSorter
{
    ArrayList<String> names = new ArrayList<>();

    public ArrayList<String> getNames()
    {
        return names;
    }

    public void setNames(ArrayList<String> names)
    {
        this.names = names;
    }

    public void addToList(String input)
    {
        this.names.add(input);
    }

    public void sortList()
    {
        Collections.sort(this.names);
    }

    public void printList()
    {
        try {
            PrintWriter write = new PrintWriter("./output/exercise41_output.txt");
            write.println("Total of "+ names.size() +" names");
            write.println("--------------------");
            for (String name : names) {
                write.println(name);
            }
            write.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
