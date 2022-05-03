package educative.arrays;

public class CheckSecondMax {

    public static int findSecondMaximum(int[] arr) {
        int sm = Integer.MIN_VALUE, max = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > max) {
                sm = max;
                max = i;
            } else if (i > sm && i != max) {
                sm = i;
            }
        }
        return sm;
    }

    public static void main(String[] args) {
        int[] arr = {9, 2, 3, 6};
        System.out.println(findSecondMaximum(arr));

    }
}
