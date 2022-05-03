package educative.arrays;

class CheckMaxMin {

    public static void maxMin(int[] arr) {
        int i = 0, j = arr.length - 1, k = 0;
        int[] res = new int[arr.length];
        while (i < j) {
            res[k++] = arr[j--];
            res[k++] = arr[i++];
        }
        if (i == j) res[k] = arr[i];

        for (i = 0; i < res.length; i++) {
            arr[i] = res[i];
        }
    }
}