package educative.arrays;

import java.util.HashMap;
import java.util.Map;

public class CheckFirstUnique {

    public static int findFirstUnique(int[] arr) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i : arr) {
            if (map.get(i) == 1) return i;
        }


        return result;
    }

    public static void main(String[] args) {
        int[] arr = {9, 2, 3, 2, 6, 6};
        System.out.println(findFirstUnique(arr));
    }

}