package educative.arrays;

public class CheckRotateArray {
    public static void rotateArray(int[] arr) {
        int last = arr[arr.length - 1];

        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i -1];
        }
        arr[0] = last;
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        rotateArray(arr);
    }
}
