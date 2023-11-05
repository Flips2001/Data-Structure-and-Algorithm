public class QuickSort implements Sorter {

    private int stepCounter;

    public static void main(String[] args) {
        int[] array = { 5, 2, 4, 6, 1, 3 };

        new QuickSort().sort(array);

        for (int j : array) {
            System.out.println(j);
        }
    }

    /**
     * Quick sort algorithm
     * @param array int[]
     */
    public void sort(int[] array) {
        stepCounter = 0;
        quickSort(array, 0, array.length - 1);
    }

    /**
     * Get step counter
     * @return int
     */
    public int getStepCounter() {
        return stepCounter;
    }

    /**
     * Helper method for quick sort algorithm
     * @param array int[]
     * @param startIndex int
     * @param endIndex int
     */
    private void quickSort(int[] array, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int pivotIndex = partition(array, startIndex, endIndex);

            quickSort(array, startIndex, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, endIndex);
        }
    }

    /**
     * Helper method for quick sort algorithm
     * @param array int[]
     * @param start int
     * @param end int
     * @return int
     */
    public int partition(int[] array, int start, int end) {
        int pivot = array[start]; // start element is the pivot value
        int count = 0; // count elements less than pivot

        // Count elements less than pivot
        for (int i = start + 1; i <= end; i++) {
            stepCounter++;
            if (array[i] <= pivot) {
                count++;
            }
        }

        // Correct position of pivot after counting
        int pivotIndex = start + count;

        // Swap the pivot element with element at its correct position
        swap(array, pivotIndex, start);

        // Initialize pointers for the elements to be swapped
        int i = start, j = end;

        // Sort elements around the pivot element
        while (i < pivotIndex && j > pivotIndex) {
            while (array[i] <= pivot) {
                stepCounter++;
                i++;
            }
            while (array[j] > pivot) {
                stepCounter++;
                j--;
            }
            if (i < pivotIndex && j > pivotIndex) {
                swap(array, i++, j--);
            }
        }

        // Return the index of pivot element after partition
        return pivotIndex;
    }

    /**
     * Swap two elements in array
     * @param array int[]
     * @param i int
     * @param j int
     */
    public void swap(int[] array, int i, int j) {
        stepCounter++;
        int temp = array[i];

        array[i] = array[j];
        array[j] = temp;
    }
}
