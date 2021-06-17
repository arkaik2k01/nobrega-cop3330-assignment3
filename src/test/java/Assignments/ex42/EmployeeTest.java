package Assignments.ex42;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    @Test
    void processInput_test() {
        //Given Mr Obama with 2 dollars
        Employee test = new Employee();
        String given = "Obama,Mr,2";

        //Expected...
        String[] expected = {"Obama", "Mr", "2"};
        //Actual...
        String[] actual = test.processInput(given);

        assertArrayEquals(expected, actual);
    }

    @Test
    void processInput_test2() {
        //Given Mr Obama with 2 dollars
        Employee test = new Employee();
        String given = "Janus,H,20000";

        //Expected...
        String[] expected = {"Janus", "H", "20000"};
        //Actual...
        String[] actual = test.processInput(given);

        assertArrayEquals(expected, actual);
    }
}