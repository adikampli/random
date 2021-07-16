package udemy;

import java.util.Arrays;

public class Palindrome {
    public boolean palindrome(String in) {
        return Arrays.stream(in.split(""))
                .reduce("", (a, b) -> b + a).equals(in);

        /*String reverse = new String();
        for (char c : in.toCharArray()) {
            reverse = c + reverse;
        }
        return reverse.equals(in);*/
    }

    public boolean intPalindrome(int in) {
        int rev = 0, temp = in;
        while (temp > 0) {
            rev = rev * 10 + temp % 10;
            temp = temp / 10;
        }
        return in == rev;
    }
}
