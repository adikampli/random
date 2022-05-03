package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(checkPalindrome(121));
    }

    private static boolean checkPalindrome(int x) {
        LinkedList<Integer> stack = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        if (x < 0)
            return false;
        while (x != 0) {
            stack.push(x % 10);
            queue.add(x % 10);
            x = x / 10;
        }

        int a = 10 + ('9' - '0');
        while (stack.peek() != null) {
            if (stack.pop() != queue.poll())
                return false;
        }
        return true;
    }
}
