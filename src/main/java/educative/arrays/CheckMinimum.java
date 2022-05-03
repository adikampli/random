package educative.arrays;

class CheckMinimum {

    public static int findMinimum(int[] arr) {
        int min = arr[0];
        for(int i : arr) {
            if(i < min) min = i;
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {9, 2, 3, 6};
//        Assertions.assertEquals(2, findMinimum(arr));
        System.out.println(findMinimum(arr));
    }
}
