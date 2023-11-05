public class SelectionSort implements Sorter {
    private int stepCounter = 0;

    public static void main(String[] args) {
        int[] array = { 5, 2, 4, 6, 1, 3 };

        new SelectionSort().sort(array);

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
     * Selection sort algorithm
     * @param array int[]
     */
    public void sort(int[] array) {
        stepCounter = 0;
        for (int i = 0; i < array.length; i++) {
            stepCounter++;
            int minIndex = findMinuIndex(array, i);
            swap(array, i, minIndex);
        }
    }

    /**
     * Find the index of the smallest element in array
     * @param array int[]
     * @param startIndex int
     * @return int
     */
    private int findMinuIndex(int[] array, int startIndex) {
        int minIndex = startIndex;

        for (int i = startIndex + 1; i < array.length; i++) {
            stepCounter++;
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }

        return minIndex;
    }

    /**
     * Swap two elements in array
     * @param array int[]
     * @param i int
     * @param j int
     */
    private void swap(int[] array, int i, int j) {
        stepCounter++;
        int temp = array[i];

        array[i] = array[j];
        array[j] = temp;
    }
}
