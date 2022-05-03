package leetcode;

import java.util.*;

public class Anagram {
    public boolean isAnagram(String s, String t) {
        Queue<Character> brackets = new ArrayDeque<>();

        if (s.length() != t.length()) return false;

        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> tmap = new HashMap<>();

        for (char c : s.toCharArray()) {
            smap.put(c, smap.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }

        for (char c : smap.keySet()) {
            if (smap.get(c).intValue() != tmap.get(c).intValue()) {
                System.out.println(smap.get(c) + " " + tmap.getOrDefault(c, 0));
                return false;

            }
        }

        return true;
    }
}
