package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

public class NumberPattern {
    public static void main(String[] args) {
        System.out.println(numberPattern("MNM"));
    }

    private static int numberPattern(String in) {
        StringBuilder builder = new StringBuilder();
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i <= in.length(); i++) {
            stack.push(i + 1);
            if (i == in.length() || in.charAt(i) == 'N') {
                while (!stack.isEmpty()) {
                    builder.append(stack.pop());
                }
            }
        }
        char[] c = "cacas".toCharArray();
        Arrays.sort(c);
        System.out.println(new String(c));
        return Integer.parseInt(builder.toString());
    }
}
