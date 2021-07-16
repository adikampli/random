package leetcode;

public class SortedArrayDuplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 2, 2, 3}));
    }

    public static int removeDuplicates(int[] nums) {
        int length = 0;
        for(int i =0;i<nums.length-1;i++){
            if(nums[i]!=nums[i+1])
                length++;
        }
        return length+1;
    }
}
