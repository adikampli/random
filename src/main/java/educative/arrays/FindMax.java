package educative.arrays;

/**
 * Kadane's algorithm to find the Sum of Maximum Sum Subarray
 */
public class FindMax {
    public static int findMaxSumSubArray(int[] arr) {
        int currSum = arr[0], globalSum = arr[0];

        for (int i : arr) {
            if (currSum < 0) {
                currSum = i;
            } else {
                currSum += i;
            }
            if (currSum > globalSum) {
                globalSum = currSum;
            }
        }

        return globalSum;
    }

    public static void main(String[] args) {
        int[] arr = {-4, 2, -5, 1, 2, 3, 6, -5, 1};
        System.out.println(findMaxSumSubArray(arr));
    }
}
