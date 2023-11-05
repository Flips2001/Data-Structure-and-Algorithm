public class HeapSort implements Sorter {

    private int stepCounter;

    public static void main(String[] args) {
        int[] array = { 5, 2, 4, 6, 1, 3 };

        new HeapSort().sort(array);

        for (int j : array) {
            System.out.println(j);
        }
    }

    /**
     * Get step counter
     * @return int
     */
    public int getStepCounter() {
        return stepCounter;
    }

    /**
     * Heap sort algorithm
     * @param array int[]
     */
    public void sort(int[] array) {
        stepCounter = 0;
        buildMaxHeap(array);

        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            maxHeapify(array, 0, i);
        }
    }

    /**
     * Helper method for heap sort algorithm
     * @param array int[]
     * @param index int
     * @param heapSize int
     */
    private void maxHeapify(int[] array, int index, int heapSize) {
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;
        int largestIndex = index;
        stepCounter++;

        if (leftIndex < heapSize && array[leftIndex] > array[largestIndex]) {
            largestIndex = leftIndex;
        }

        if (rightIndex < heapSize && array[rightIndex] > array[largestIndex]) {
            largestIndex = rightIndex;
        }

        if (largestIndex != index) {
            swap(array, index, largestIndex);
            maxHeapify(array, largestIndex, heapSize);
        }
    }

    /**
     * Helper method for heap sort algorithm
     * @param array int[]
     */
    private void buildMaxHeap(int[] array) {
        for (int i = array.length / 2; i >= 0; i--) {
            maxHeapify(array, i, array.length);
        }
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
