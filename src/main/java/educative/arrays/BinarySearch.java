package educative.arrays;

public class BinarySearch {
    static int binSearch(int[] a, int key) {
        return binarySearch(0, a.length, a, key);
    }

    static int binarySearch(int start, int end, int[] a, int key) {
        if (start > end) {
            return -1;
        }
        int mid = start + ((end - start) / 2);

        if (a[mid] == key) return mid;
        else if (a[mid] > key) return binarySearch(start, mid - 1, a, key);
        else return binarySearch(mid + 1, end, a, key);
    }

    public static void main(String[] args) {
        int[] arr = {2, 6, 8, 23, 57, 233};
        System.out.println(binSearch(arr, 57));
    }
}
