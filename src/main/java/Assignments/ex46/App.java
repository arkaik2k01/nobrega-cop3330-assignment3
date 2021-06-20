package Assignments.ex46;

/*
Exercise 46 - Word Frequency Finder
Knowing how often a word appears in a sentence or block of text is helpful for creating word clouds and other types of word analysis.
And it’s more useful when running it against lots of text.

Create a program that reads in a file named `exercise46_input.txt` and counts the frequency of words in the file.
Then construct a histogram displaying the words and the frequency, and display the histogram to the screen.

Example Output
Given the text file `exercise46_input.txt` with this content
badger badger badger
badger mushroom
mushroom snake badger badger
badger
the program would produce the following output:
badger:   *******
mushroom: **
snake:    *

Constraint
Ensure that the most used word is at the top of the report and the least used words are at the bottom.
Challenges
Use a graphical program and generate bar graphs.
Test the performance of your calculation by providing a very large input file, such as Shakespeare's Macbeth.
Tweak your algorithm so that it performs the word counting as fast as possible.
Write the program in another language and compare the processing times of the two implementations.
*/

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class App
{
    private static final Frequency freq = new Frequency();

    public static void main(String[] args)
    {
        App prog = new App();
        //Construct file reader
        File input = new File("./input/exercise46_input.txt");
        //Read from file until EOF
        //Add words read in to Map
        prog.getInput(input);

        //Sort map by value
        freq.setFreq(freq.reverseOrder(freq.getFreq()));
        //Print map key
        //For loop to print * depending on key value
        prog.sendOutput();
    }

    private void getInput(File input)
    {
        try {
            Scanner in = new Scanner(input);
            while (in.hasNext()) {
                freq.addToMap(in.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendOutput()
    {
        //Iterate through map values
        for (Map.Entry<String, Integer> entry : freq.getFreq().entrySet()) {
            //Get map entries and send to print key
            System.out.println(freq.printKey(entry));
        }
    }

}
