package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumberChecker {
    public static void main(String[] args) {
        System.out.println(numberChecker(new int[]{1456, 345671, 43218, 123}));
    }

    private static List<Integer> numberChecker(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            boolean one = false, two = false, three = false;
            int num = nums[i];
            while (num != 0) {
                if (num % 10 == 1) one = true;
                if (num % 10 == 2) two = true;
                if (num % 10 == 3) three = true;
                num = num / 10;
            }
            if (one && two && three) res.add(nums[i]);
        }
        Collections.sort(res);
        return res;
    }
}
