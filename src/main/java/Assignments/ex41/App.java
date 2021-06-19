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

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class App
{
    public static void main(String[] args)
    {
        //Create class vars
        App prog = new App();
        NameSorter sorter = new NameSorter();

        //Create a scanner that points towards the file
        //Make while loop that will add names to an ArrayList in NameSorter until EOF
        prog.getInput(sorter);

        //Sort all names inside the ArrayList
        sorter.sortList();
        //Call a method to iterate through the ArrayList and print the names
        sorter.printList();
    }

    private void getInput(NameSorter sorter)
    {
        try {
            Scanner in = new Scanner(new File("./input/exercise41_input.txt"));
            while(in.hasNextLine()) {
                String input = in.nextLine();
                sorter.addToList(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
