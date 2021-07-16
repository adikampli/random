package leetcode;

import java.util.LinkedList;

public class ReverseInt {
    public static void main(String[] args) {
        int x = -123;
        System.out.println(reverseInt(x));
    }

    private static int reverseInt(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            if (rev > (Integer.MAX_VALUE / 10) || (rev == (Integer.MAX_VALUE / 10) && pop > 7))
                return 0;
            if (rev < (Integer.MIN_VALUE / 10) || (rev == (Integer.MIN_VALUE / 10) && pop < -8))
                return 0;
           /* if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;*/
            rev = rev * 10 + pop;
        }
        return rev;
    }

}
