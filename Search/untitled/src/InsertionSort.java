public class InsertionSort implements Sorter {

    private int stepCounter = 0;

    public static void main(String[] args) {
        int[] array = { 5, 2, 4, 6, 1, 3 };

        new InsertionSort().sort(array);

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
     * Insertion sort algorithm
     * @param array int[]
     */
    public void sort(int[] array) {
        stepCounter = 0;
        for (int i = 1; i < array.length; i++) {
            stepCounter++;
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                stepCounter++;
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;
        }
    }
}
