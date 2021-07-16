package udemy;

import java.util.HashMap;
import java.util.Map;

public class MaxChars {
    public char maxChars(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0).intValue() + 1);
        }
        int max = 0;
        char maxChar = 0;
        for (Map.Entry<Character, Integer> i : map.entrySet()) {
            max = Math.max(i.getValue(), max);
            maxChar = i.getValue() == max ? i.getKey() : maxChar;
        }
        return maxChar;
    }
}
