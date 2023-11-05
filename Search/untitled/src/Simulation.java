import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Simulation {
    public static void main(String[] args) throws Exception {
        int[] inputSizes = {50000};
        Sorter[] sorters = new Sorter[]{
                new HeapSort(),
                new InsertionSort(),
                new MergeSort(),
                new SelectionSort(),
                new QuickSort()
        };

        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Future<String>> results = new ArrayList<>();

        for (int size : inputSizes) {
            for (Sorter sorter : sorters) {
                int[] array = generateRandomNumbers(size);
                int[] descendingArray = Arrays.stream(array.clone()).boxed().sorted(Collections.reverseOrder()).mapToInt(i -> i).toArray();
                int[] ascendingArray = Arrays.stream(array.clone()).boxed().sorted().mapToInt(i -> i).toArray();
                Callable<String> task = () -> simulateSort(descendingArray, sorter); // for different simulations use ascendingArray, descendingArray, or array
                results.add(executor.submit(task));
            }
        }

        for (Future<String> result : results) {
            System.out.println(result.get());
        }

        executor.shutdown();
    }

    public static void simulateRandomSorters(int n, Sorter[] sorters) {
        for (Sorter sorter : sorters) {
            simulateSort(generateRandomNumbers(n), sorter);
        }
    }

    public static void simulateDescendingSorters(int n, Sorter[] sorters) {
        for (Sorter sorter : sorters) {
            simulateSort(Arrays.stream(generateRandomNumbers(n)).sorted().toArray(), sorter);
        }
    }

    public static int[] generateRandomNumbers(int n) {
        int[] numbers = new int[n];
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            numbers[i] = rnd.nextInt(n);
        }
        return numbers;
    }

    public static String simulateSort(int[] array, Sorter sorter) {
        long totalSteps = 0;
        int simulations = 1000;

        for (int i = 0; i < simulations; i++) {
            sorter.sort(array.clone()); // Ensure each simulation uses a fresh array copy
            totalSteps += sorter.getStepCounter();
        }

        long averageSteps = totalSteps / simulations;
        return "Average steps for " + sorter.getClass().getName() + " with " + array.length + " elements: " + averageSteps;
    }
}
