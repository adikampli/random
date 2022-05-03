package educative.arrays;

import java.util.Arrays;

/**
 * Given an array of size n, remove all even integers from it.
 * Implement this solution in Java and see if it runs without an error.
 */
public class EvenNumbers {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 10, 6, 3};
        int[] ints = removeEven(arr);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
        Arrays.asList(ints)
                .forEach(System.out::println);
    }

    static int[] removeEven(int[] arr) {
        int[] filteredArr = new int[arr.length];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) filteredArr[j++] = arr[i];
        }
        return filteredArr;
    }
}
