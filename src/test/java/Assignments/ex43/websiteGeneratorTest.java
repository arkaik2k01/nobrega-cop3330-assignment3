package Assignments.ex43;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class websiteGeneratorTest
{


    @Test
    void createFolder()
    {
        //Given
        websiteGenerator test = new websiteGenerator();
        test.setSite("testing");

        //Expected....
        int expected = 0;
        int result = test.createFolder("test");

        assertEquals(expected, result);
    }

    @Test
    void createIndex()
    {
        //Given
        websiteGenerator test = new websiteGenerator();
        test.setSite("testing");

        //Expected....
        int expected = 0;
        int result = test.createIndex();

        assertEquals(expected, result);
    }

    @Test
    void createWebsite()
    {
    }

    @Test
    void isCreated()
    {
    }
}