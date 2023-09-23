import java.util.Vector;

public class DoubleLinkedListApplication {
    public static void main(String[] args) {
        DoubleLinkedList<String> myList = new DoubleLinkedList<>();

        // Insert elements at front
        myList.pushFront("Wien");
        myList.pushFront("Graz");
        myList.insert(1, "Linz");
        myList.popBack();
        myList.pushBack("Salzburg");
        myList.popFront();
        myList.pushBack("Innsbruck");
        myList.pushBack("Salzburg");


        System.out.println("Doubly linked list is as follows: ");
        myList.displayList();

        System.out.println("Copied list is as follows: ");
        DoubleLinkedList<String> myCopy = myList.copy();
        myCopy.displayList();

        myCopy.pushFront("Bregenz");
        myCopy.pushBack("Klagenfurt");
        myCopy.pushBack("Linz");
        myCopy.pushBack("St. Pölten");
        myCopy.pushBack("Eisenstadt");
        System.out.println("Copied list after inserting is as follows: ");
        myCopy.displayList();

        System.out.println("After deleting Linz: ");
        myCopy.deleteItem("Linz");
        myCopy.displayList();

        myCopy.delete(5);
        System.out.println("After deleting element at index 5: ");
        myCopy.displayList();

        System.out.println("Reversed list is as follows: ");
        myCopy.reverseList();
        myCopy.displayList();

        System.out.println("Search for Salzburg: ");
        Vector<Integer> indices = myCopy.search("Salzburg");
        for (Integer index : indices) {
            System.out.println("Salzburg at index: " + index);
        }
    }
}
