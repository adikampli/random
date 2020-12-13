import java.util.HashMap;
import java.util.Map;

public class Random {
    public static void main(String[] args) {
        twoSum(new int[]{3, 2, 4}, 6);
    }

    /**
     * Given an array of integers nums and an integer target,
     * return indices of the two numbers such that they add up to target.
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> comp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (comp.containsKey(nums[i]))
                return new int[]{comp.get(nums[i]), i};
            else {
                comp.put((target - nums[i]), i);
            }
        }
        return new int[]{};
    }
}