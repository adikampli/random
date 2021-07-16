package leetcode;

public class RemoveValueFromArray {
    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{1,2,3,3}, 3));
    }

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for(int j = 0;j<nums.length;j++) {
            if(nums[j]!=val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
