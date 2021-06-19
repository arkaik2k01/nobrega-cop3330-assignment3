package Assignments.ex46;

import java.util.TreeMap;

public class Frequency
{
    private TreeMap<String, Integer> freq = new TreeMap<>();

    public void addToMap(String word)
    {
        if(freq.containsKey(word)) {
            int num = freq.get(word) + 1;
            freq.put(word, num);
        }
        else {
            freq.put(word, 0);
        }

    }

    public TreeMap<String, Integer> reverseOrder()
    {

    }

    public TreeMap<String, Integer> getFreq()
    {
        return freq;
    }
}
