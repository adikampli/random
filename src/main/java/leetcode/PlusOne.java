package leetcode;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{9,8,9})));
    }

    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        if (digits[length - 1] != 9)
            digits[length - 1] = digits[length - 1] + 1;
        else {
            for (int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] == 9) digits[i] = 0;
                else {
                    digits[i] += 1;
                    break;
                }
            }

            if (digits[0] == 0) {
                int[] newDigits = new int[length + 1];
                newDigits[0] = 1;
                System.arraycopy(digits, 0, newDigits, 1, length);
                return newDigits;
            }
        }

        return digits;
    }

}
