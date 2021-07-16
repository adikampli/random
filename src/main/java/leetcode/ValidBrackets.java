package leetcode;

import java.util.HashMap;
import java.util.Stack;

public class ValidBrackets {
    public static void main(String[] args) {
        System.out.println(isValid("]"));
    }

    public static boolean isValid(String s) {
        Stack<Character> list = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                list.push(c);
            } else {
                if (!list.empty() && map.get(list.peek()) == c)
                    list.pop();
                else
                    return false;
            }
        }
        return list.size() == 0;
    }
}
