package leetcode;

public class SearchInsertPosition {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 3));
    }

    public static int searchInsert(int[] nums, int target) {
        return binarySearch(0, nums.length-1, nums, target);
    }

    public static int binarySearch(int start, int end, int[] nums, int target) {
        if(end >= start) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) return mid;
            if (target > nums[mid])
                return binarySearch(mid+1, end, nums, target);
            else
                return binarySearch(start, mid-1, nums, target);
        }
        return start;
    }
}
