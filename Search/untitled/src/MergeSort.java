public class MergeSort implements Sorter{

    private int stepCounter;
    public static void main(String[] args) {
        int[] array = { 5, 2, 4, 6, 1, 3 };

        new MergeSort().sort(array);

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
     * Merge sort algorithm
     * @param array int[]
     */
    public void sort(int[] array) {
        stepCounter = 0;
        mergeSort(array, 0, array.length - 1);
    }

    /**
     * Helper method for merge sort algorithm
     * @param array int[]
     * @param startIndex int
     * @param endIndex int
     */
    private void mergeSort(int[] array, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int middleIndex = (startIndex + endIndex) / 2;

            mergeSort(array, startIndex, middleIndex);
            mergeSort(array, middleIndex + 1, endIndex);

            merge(array, startIndex, middleIndex, endIndex);
        }
    }

    /**
     * Helper method for merge sort algorithm
     * @param array int[]
     * @param left int
     * @param mid int
     * @param right int
     */
    private void merge(int[] array, int left, int mid, int right) {
        int lenArrayOne = mid - left + 1;
        int lenArrayTwo = right - mid;

        int[] leftArray = new int[lenArrayOne];
        int[] rightArray = new int[lenArrayTwo];

        System.arraycopy(array, left, leftArray, 0, lenArrayOne);
        stepCounter += lenArrayOne;

        System.arraycopy(array, mid + 1, rightArray, 0, lenArrayTwo);
        stepCounter += lenArrayTwo;

        int indexOfSubArrayOne = 0, indexOfSubArrayTwo = 0;
        int indexOfMergedArray = left;
        while (indexOfSubArrayOne < lenArrayOne && indexOfSubArrayTwo < lenArrayTwo) {
            stepCounter++;

            if (leftArray[indexOfSubArrayOne] <= rightArray[indexOfSubArrayTwo]) {
                array[indexOfMergedArray] = leftArray[indexOfSubArrayOne];
                indexOfSubArrayOne++;
            } else {
                array[indexOfMergedArray] = rightArray[indexOfSubArrayTwo];
                indexOfSubArrayTwo++;
            }
            indexOfMergedArray++;
        }

        while (indexOfSubArrayOne < lenArrayOne) {
            stepCounter++;

            array[indexOfMergedArray] = leftArray[indexOfSubArrayOne];
            indexOfSubArrayOne++;
            indexOfMergedArray++;
        }

        while (indexOfSubArrayTwo < lenArrayTwo) {
            stepCounter++;

            array[indexOfMergedArray] = rightArray[indexOfSubArrayTwo];
            indexOfSubArrayTwo++;
            indexOfMergedArray++;
        }
    }
}
