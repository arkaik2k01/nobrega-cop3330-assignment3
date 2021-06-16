package Assignments.ex41;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NameSorterTest
{

    @Test
    void addToList()
    {
        //Given...
        NameSorter test = new NameSorter();
        ArrayList<String> expected = new ArrayList<>();
        expected.add("Look");
        expected.add("A");
        expected.add("Test");

        //When list with "Look","A" gets added "Test", expected true
        ArrayList<String> result = new ArrayList<>();
        result.add("Look");
        result.add("A");
        test.setNames(result);
        test.addToList("Test");

        assertIterableEquals(expected, result);

    }

    @Test
    void sortList()
    {
        NameSorter test = new NameSorter();
        ArrayList<String> expected = new ArrayList<>();
        expected.add("A");
        expected.add("Look");
        expected.add("Test");

        //When list with "Look","A" an "Test" sorted, expected "A" "Look" "Test"
        test.addToList("Look");
        test.addToList("A");
        test.addToList("Test");
        test.sortList();

        assertIterableEquals(expected, test.getNames());

    }
}