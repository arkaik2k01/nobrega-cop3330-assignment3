package Assignments.ex46;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Frequency
{
    private Map<String, Integer> freq = new TreeMap<>();

    public void addToMap(String word)
    {
        if (freq.containsKey(word)) {
            int num = freq.get(word) + 1;
            freq.put(word, num);
        } else {
            freq.put(word, 1);
        }

    }

    public Map<String, Integer> reverseOrder(Map<String, Integer> map)
    {
        Compare comparator = new Compare(map);

        Map<String, Integer> reversed = new TreeMap<>(comparator);

        reversed.putAll(map);

        return reversed;
    }

    public Map<String, Integer> getFreq()
    {
        return freq;
    }

    public void setFreq(Map<String, Integer> freq)
    {
        this.freq = freq;
    }

    public String printKey(Map.Entry<String, Integer> entry)
    {
        StringBuilder out = new StringBuilder(entry.getKey() + ": ");
        for (int i = 0; i < entry.getValue(); i++) out.append("*");
        return out.toString();
    }
}

class Compare implements Comparator<Object>
{

    Map<String, Integer> map;

    public Compare(Map<String, Integer> map)
    {
        this.map = map;
    }

    public int compare(Object o1, Object o2)
    {

        if (map.get(o2).equals(map.get(o1))) {
            return 1;
        } else
            return map.get(o2).compareTo(map.get(o1));

    }
}