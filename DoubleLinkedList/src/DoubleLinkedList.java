import java.util.Vector;

public class DoubleLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int count;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    /** create a new node **/
    private Node<T> createNewNode(T data) {
        return new Node<T>(data);
    }

    /** delete the node pointed at by the prevNode **/
    public T deleteAfter(Node<T> prevNode) {
        if (prevNode == null || prevNode.next == null) {
            return null;
        }
        Node<T> nodeDelete = prevNode.next;
        T value = nodeDelete.data;
        prevNode.next = nodeDelete.next;
        if (nodeDelete.next != null) {
            nodeDelete.next.prev = prevNode;
        }
        count--;
        return value;
    }

    /** Given a node as prev_node, insert a new node after the given node **/
    private void insertAfter(Node<T> prevNode, T value) {
        if (prevNode == null) {
            throw new IllegalArgumentException("Previous node is required, it cannot be NULL");
        }
        Node<T> nextNode = prevNode.next;
        Node<T> newNode = createNewNode(value);
        newNode.next = nextNode;
        prevNode.next = newNode;
        newNode.prev = prevNode;
        if (nextNode != null) {
            nextNode.prev = newNode;
        }
        count++;
    }

    /* inserts node at the front of the list */
    public void pushFront(T value) {
        Node<T> newNode = createNewNode(value);
        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            head = newNode;
            tail = newNode;
        }
        count++;
    }

    /** value is inserted at a specified position **/
    public boolean insert(int index, T value) {
        if (index < 0 || index > count) {
            return false;
        }
        if (index == 0) {
            pushFront(value);
        } else if (index == count) {
            pushBack(value);
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            insertAfter(current, value);
        }
        return true;
    }

    /* inserts node at the back of the list */
    public void pushBack(T value) {
        Node<T> newNode = createNewNode(value);
        if (tail != null) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            head = newNode;
            tail = newNode;
        }
        count++;
    }

    /** removes the front element and returns the value in data **/
    public T popFront() {
        if (count == 0 || head == null) {
            return null;
        }
        T value = head.data;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        count--;
        return value;
    }

    /** removes the last element and returns the value in data **/
    public T popBack() {
        if (count == 0 || tail == null) {
            return null;
        }
        T value = tail.data;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        count--;
        return value;
    }

    /** delete element at index position **/
    public T delete(int index) {
        if (index < 0 || index >= count || head == null) {
            return null;
        }
        if (index == 0) {
            return popFront();
        } else if (index == count - 1) {
            return popBack();
        } else if (index > count / 2) {
            Node<T> current = tail;
            for (int i = count - 1; i > index; i--) {
                current = current.prev;
            }
            return deleteAfter(current.prev);
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            return deleteAfter(current);
        }
    }

    /** This function returns the data at index position (for a valid index) **/
    public T elementAt(int index) {
        if (index < 0 || index >= count || head == null) {
            return null;
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    /** his function prints contents of linked list **/
    public void displayList() {
        Node<T> node = head;
        while (node != null) {
            System.out.print(node.data + "<==>");
            node = node.next;
        }
        System.out.println("END");
    }

    /** change the following to traverse the list in reversed order (backward) **/
    public void displayListBackward() {
        Node<T> node = tail;
        while (node != null) {
            System.out.print(node.data + "<==>");
            node = node.prev;
        }
        System.out.println("END");
    }

    /** reverses the elements of a doubly linked list **/
    public boolean reverseList() {
        if (count == 0 || head == null) {
            return false;
        }
        Node<T> hNode = head;
        Node<T> tNode = tail;

        for (int i = 0; i < count / 2; i++) {
            T temp = hNode.data;
            hNode.data = tNode.data;
            tNode.data = temp;

            hNode = hNode.next;
            tNode = tNode.prev;
        }
        return true;
    }

    /** returns a copy of the list **/
    public DoubleLinkedList<T> copy() {
        DoubleLinkedList<T> newList = new DoubleLinkedList<>();
        Node<T> node = head;
        while (node != null) {
            newList.pushBack(node.data);
            node = node.next;
        }
        return newList;
    }

    public void deleteItem(T item) {
        Node<T> node = head;
        while (node != null) {
            if (node.data.equals(item)) {
                if (node == head) {
                    popFront();
                } else if (node == tail) {
                    popBack();
                } else {
                    deleteAfter(node.prev);
                }
            }
            node = node.next;
        }
    }

    public Vector<Integer> search(T searchItem) {
        Vector<Integer> indices = new Vector<>();
        Node<T> currentNode = head;
        int index = 0;
        while (currentNode != null) {
            if (searchItem.equals(currentNode.data)) {
                indices.add(index);
            }
            currentNode = currentNode.next;
            index++;
        }
        return indices;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

}
