package educative.arrays;

class ProductArray {
    public static int[] findProduct(int arr[]) {
        int[] result = new int[arr.length];
        int product = 1;

       /* for (int i = 0; i < arr.length; i++) {
            product = 1;
            for (int j = 0; j < arr.length; j++) {
                if (i != j) {
                    product *= arr[j];
                }
            }
            result[i] = product;
        }*/

        for (int i = 0; i < arr.length; i++) {
            result[i] = product;
            product *= arr[i];
        }
        product = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            result[i] *= product;
            product *= arr[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int[] product = findProduct(arr);
        for (int i : product) {
            System.out.println(i);
        }
    }
}