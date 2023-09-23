import java.util.Arrays;

public class DoubleLinearSearch {

    public static void main(String[] args) {
        int[] arr = new int[]{10, 50, 16, 1, 9, 15, 16, 20, 16, 2, 5};
        int target = 10;

        int[] result = doubleLinearSearch(arr, target);
        System.out.println("array: " + Arrays.toString(arr));
        System.out.println("target: " + target);
        System.out.println("result: " + Arrays.toString(result));

        target = 16;
        result = doubleLinearSearch(arr, target);
        System.out.println("array: " + Arrays.toString(arr));
        System.out.println("target: " + target);
        System.out.println("result: " + Arrays.toString(result));
    }

    private static int[] doubleLinearSearch(int[] arr, int target) {
        int[] result = {-1, -1};

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                if (result[0] == -1) {
                    result[0] = i;
                } else {
                    result[1] = i;
                }
            }

            if (result[1] != -1) {
                return result; // early break
            }
        }

        return new int[]{-1};
    }
}
