package Assignments.ex43;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Miguel Nobrega
 */

/*
Exercise 43 - Website Generator
Create a program that generates a website skeleton with the following specifications:
Prompt for the name of the site.
Prompt for the author of the site.
Ask if the user wants a folder for JavaScript files.
Ask if the user wants a folder for CSS files.
Generate an index.html file that contains the name of the site inside the <title> tag and the author in a <meta> tag.\

Example Output
Site name: awesomeco
Author: Max Power
Do you want a folder for JavaScript? y
Do you want a folder for CSS? y
Created ./website/awesomeco
Created ./website/awesomeco/index.html
Created ./website/awesomeco/js/
Created ./website/awesomeco/css/
The user should then find these files and directories created in the working directory of your program.

Challenges
Implement this in a scripting language on Windows, OSX, and Linux.
Implement this as a web application that provides the specified site as a zip file.
*/

import java.util.Scanner;

public class App
{
    private static final Scanner in = new Scanner(System.in);
    private static final App prog = new App();

    public static void main(String[] args)
    {
        //Create program variables

        websiteGenerator generator = new websiteGenerator();

        //Get input from user
        //Save site name and set in generator
        generator.setSite(prog.getInput("Site name: "));
        //Save author name and set in generator
        generator.setAuthor(prog.getInput("Author: "));
        //Ask if JS and set in generator
        generator.setJScript(prog.wantsOptFolders("Do you want a JavaScript folder?"));
        //Ask if CSS and set in generator
        generator.setCSS(prog.wantsOptFolders("Do you want a CSS folder?"));

        //Create main folder
        //Create and print to index
        //Create js folder if necessary
        //Create css folder if necessary
        generator.createWebsite();
    }

    private Boolean wantsOptFolders(String prompt)
    {
        String input = prog.getInput(prompt);
        return input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y");
    }

    private String getInput(String prompt)
    {
        System.out.print(prompt);
        return in.nextLine();
    }
}
