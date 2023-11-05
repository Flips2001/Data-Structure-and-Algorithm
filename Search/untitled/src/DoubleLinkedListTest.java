public class DoubleLinkedListTest {
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
    }
}
