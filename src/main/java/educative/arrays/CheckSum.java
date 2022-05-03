package educative.arrays;

import java.util.HashMap;

/**
 * Given an array and a number "n", find two numbers from the array that sums up to "n".
 */
public class CheckSum {
    public static int[] findSum(int[] arr, int n) {
        int[] result = new int[2];
        HashMap<Integer, Integer> diffMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (diffMap.containsKey(n - arr[i])) {
                result[0] = arr[i];
                result[1] = n - arr[i];
                return result;
            }
            diffMap.put(arr[i], n - arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 21, 3, 14, 5, 60, 7, 6};
        int value = 27;
        int[] sum = findSum(arr, value);
        for (int i : sum) {
            System.out.println(i);
        }
    }
}
