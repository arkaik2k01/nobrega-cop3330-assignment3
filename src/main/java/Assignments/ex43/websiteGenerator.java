package Assignments.ex43;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Miguel Nobrega
 */

/*
Exercise 43 - Website Generator
Programming languages can create files and folders too.

Create a program that generates a website skeleton with the following specifications:
Prompt for the name of the site.
Prompt for the author of the site.
Ask if the user wants a folder for JavaScript files.
Ask if the user wants a folder for CSS files.
Generate an index.html file that contains the name of the site inside the <title> tag and the author in a <meta> tag.

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

public class websiteGenerator
{
    private String site, author;
    private Boolean isJScript, isCSS;

    public int createFolder(String folder)
    {
        File f = new File("./src/main/java/Assignments/ex43/website/" + this.site + folder);
        try {
            if (f.mkdirs()) {
                return 0;
            } else {
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    public int createIndex()
    {
        File f = new File("./src/main/java/Assignments/ex43/website/" + this.site + "/index.html");
        try {
            if (f.createNewFile()) {
                return 0;
            } else {
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    public int writeToIndex()
    {
        try {
            FileWriter output = new FileWriter("./src/main/java/Assignments/ex43/website/" + this.site + "/index.html");
            output.write("<title>" + this.site + "</title>\n");
            output.write("<meta>" + this.author + "</meta>\n");
            output.close();
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
            return 1;
        }
    }

    public int createWebsite()
    {
        int success;
        try {
            //Create main folder
            success = createFolder("");
            isCreated(success, "");
            //Create index, write to index
            success = createIndex();
            isCreated(success, "/index.html");
            writeToIndex();
            //Create optional folders
            if (this.isJScript) {
                success = createFolder("/js");
                isCreated(success, "/js");
            }
            if (this.isCSS) {
                success = createFolder("/css");
                isCreated(success, "/css");
            }
            //Success!
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            // :(
            return 1;
        }
    }

    public void isCreated(int success, String file)
    {
        if(success == 0) {
            System.out.println("Created src/main/java/Assignments/ex43/website/" + this.site + file);
        }
        else
        {
            System.out.println("ERROR at "+file);
        }
    }

    public String getSite()
    {
        return site;
    }

    public void setSite(String site)
    {
        this.site = site;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public Boolean getJScript()
    {
        return isJScript;
    }

    public void setJScript(Boolean JScript)
    {
        isJScript = JScript;
    }

    public Boolean getCSS()
    {
        return isCSS;
    }

    public void setCSS(Boolean CSS)
    {
        isCSS = CSS;
    }
}
