package Assignments.ex45;

/*
Exercise 45 - Word Finder
There will be times when you'll need to read in one file, modify it, and then write a modified version of that file to a
new file.
Given an input file named `exercise45_input.txt`, read the file and look for all occurrences of the word utilize.
Replace each occurrence with use. Write the modified file to a new file.

Example Output
Given the input file of

One should never utilize the word "utilize" in writing. Use "use" instead.
For example, "She uses an IDE to write her Java programs" instead of "She
utilizes an IDE to write her Java programs".
The program should generate
One should never use the word "use" in writing. Use "use" instead.
For example, "She uses an IDE to write her Java programs" instead of "She
uses an IDE to write her Java programs".

Constraints
Prompt for the name of the output file.
Write the output to a new file.
Challenges
Modify the program to track the number of replacements and report that to the screen when the program finishes.
Create a configuration file that maps “bad” words to “good” words and use this file instead of a hard-coded value.
Modify the program so that it can handle every file in a folder of files instead of a single file.

*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class App
{
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args)
    {
        App prog = new App();
        //Ask user the name of the file to output
        String outFile = prog.promptFile();
        //Get input from txt
        String text = prog.getInput();
        //Replace "utilize" with "use"
        assert text != null;
        text = prog.replaceWord(text, "utilize", "use");
        //Print output
        prog.printFile(outFile, text);
    }

    private String getInput()
    {
        try {
            Scanner in = new Scanner(new File("./input/exercise45_input.txt"));
            StringBuilder input = new StringBuilder();
            //Read all input until EOF
            while (in.hasNextLine()) {
                input.append(in.nextLine()).append("\n");
            }
            return input.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String promptFile()
    {
        //Ask user for file
        System.out.println("What would you like to name your output file? ");
        return in.next();
    }

    private void printFile(String file, String text)
    {
        //Print to file
        File f = new File("./output/"+file+".txt");
        try {
            PrintWriter write = new PrintWriter(f);
            write.println(text);
            write.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String replaceWord(String text, String replace, String replaceWith)
    {
        //Replace word
        return text.replaceAll(replace, replaceWith);
    }
}
