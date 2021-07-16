package leetcode;

import java.util.Collections;

class RomanToInt {
    public static int romanToInt(String s) {
        int lastNumber = 0;
        System.out.println(String.join("", Collections.nCopies(42, "I"))
                .replace("IIIII", "V")
                .replace("IIII", "IV")
                .replace("VV", "X")
        .replace("XXXXX", "L")
                .replace("XXXX", "XL")
        .replace("XXXX", "XL"));
        int decimal = 0;
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            switch (chars[i]) {
                case 'I':
                    decimal = processDecimal(1, lastNumber, decimal);
                    lastNumber = 1;
                    break;
                case 'V':
                    decimal = processDecimal(5, lastNumber, decimal);
                    lastNumber = 5;
                    break;
                case 'X':
                    decimal = processDecimal(10, lastNumber, decimal);
                    lastNumber = 10;
                    break;
                case 'L':
                    decimal = processDecimal(50, lastNumber, decimal);
                    lastNumber = 50;
                    break;
                case 'C':
                    decimal = processDecimal(100, lastNumber, decimal);
                    lastNumber = 100;
                    break;
                case 'D':
                    decimal = processDecimal(500, lastNumber, decimal);
                    lastNumber = 500;
                    break;
                case 'M':
                    decimal = processDecimal(1000, lastNumber, decimal);
                    lastNumber = 1000;
                    break;
            }
        }
        return decimal;
    }

    static int processDecimal(int num, int lastNum, int decimal) {
        if (lastNum > num) {
            return decimal - num;
        } else {
            return decimal + num;
        }
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));
    }
}
