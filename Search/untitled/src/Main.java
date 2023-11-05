public class Main {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> myList = new DoubleLinkedList<>();

        myList.pushBack(1);
        myList.pushBack(3);
        myList.pushBack(2);
        myList.pushBack(6);
        myList.pushBack(5);
        myList.pushBack(4);

        myList.displayList();
        myList.sort();
        myList.displayList();

        long totalSteps = 0;
        int simulations = 1000;

        Sorter sorter = new SelectionSort();
        int[] array = Simulation.generateRandomNumbers(50000);
        for (int i = 0; i < simulations; i++) {
            sorter.sort(array);
            totalSteps += sorter.getStepCounter();
        }

        long averageSteps = totalSteps / simulations;
        System.out.println("Average steps for " + sorter.getClass().getName() + " with " + array.length + " elements: " + averageSteps);
    }
}