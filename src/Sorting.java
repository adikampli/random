import java.util.Set;
import java.util.TreeSet;

public class Sorting {
    public static void main(String[] args) {
        int[] arr = {10, 2, 4, 6, 7};

        TreeSet<String> set = new TreeSet<>();

        set.add("100");
        set.add("23");
        Set descendingSet = set.descendingSet();
        descendingSet.forEach(System.out::println);
        set.forEach(System.out::println);
//        bubbleSort(arr);

//        selectionSort(arr);

//        insertionSort(arr);
//
//        for (int value : arr) System.out.println(value);
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int next = arr[i];
            int j;
            for (j = i; j > 0 && next < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = next;
        }
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
}
