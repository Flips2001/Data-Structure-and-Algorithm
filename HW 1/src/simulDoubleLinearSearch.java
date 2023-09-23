import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

public class simulDoubleLinearSearch {
    public static void main(String[] args) {
        Random random = new Random();

        int[] N = new int[]{10, 20, 35, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300};

        for (int n: N) {
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < 1000; i++) {

                int[] arr = IntStream.generate(() -> random.nextInt(15001))
                        .limit(n * 1000)
                        .toArray();

                int target = random.nextInt(15001);;
                int[] result = doubleLinearSearch(arr, target);

                if (result[0] == -1) {
                    map.put("misses", map.getOrDefault("misses", 0) + 1);
                } else {
                    map.put("hits", map.getOrDefault("hits", 0) + 1);
                }
                map.put("minSteps", Math.min(map.getOrDefault("minSteps", Integer.MAX_VALUE), result[1]));
                int currentAvg = map.getOrDefault("averageSteps", 0);
                map.put("averageSteps", (currentAvg * n + result[1]) / (n + 1));
            }
            System.out.println(n + "K" + ": " + map.toString());
        }
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
                return new int[]{0, i + 1}; // early break
            }
        }

        return new int[]{-1, arr.length};
    }
}