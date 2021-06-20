package Assignments.ex46;

import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FrequencyTest
{

    @Test
    void addToMap_test1()
    {
        //Given map with value in already....
        Frequency freq = new Frequency();
        freq.getFreq().put("test me!", 1);


        //When added, test me! , map entry expected to 2
        freq.addToMap("test me!");
        int expected = 2;

        assertEquals(expected, freq.getFreq().get("test me!"));

    }

    @Test
    void addToMap_test2()
    {
        //Given map...
        Frequency freq = new Frequency();


        //When added, test me! , map entry expected to 1
        freq.addToMap("test me!");
        int expected = 1;

        assertEquals(expected, freq.getFreq().get("test me!"));

    }

    @Test
    void printKey()
    {
        //Given map....
        Frequency freq = new Frequency();
        freq.getFreq().put("hello!", 8);
        Map.Entry<String, Integer> entry = freq.getFreq().entrySet().iterator().next();

        //Expected...
        String expected = "hello!: ********";
        String actual = freq.printKey(entry);

        assertEquals(expected, actual);
    }
}