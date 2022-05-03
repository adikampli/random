package leetcode;

public class DivideFractions {
    public static int[] divide(int[] num1, int[] num2) {
        int num = num1[1] * num2[0] + num1[0] * num2[1];
        int den = num1[1] * num2[1];

        int gcd = gcd(num, den);

        return new int[]{num / gcd, den / gcd};
    }

    public static int gcd(int num, int den) {
        if (num != 0) return gcd(den % num, num);
        else return den;
    }

    public static void main(String[] args) {
        int[] res = divide(new int[]{2, 2}, new int[]{1, 3});
        System.out.println(res[0] + " / " + res[1]);
    }
}
