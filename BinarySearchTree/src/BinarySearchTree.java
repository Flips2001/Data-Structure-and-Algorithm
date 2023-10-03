import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {
    private final List<T> tree;
    private int size = 0;
    private int height = 0;

    public BinarySearchTree() {
        tree = new ArrayList<>();
        tree.add(null);
    }

    /** copy constructor */
    public BinarySearchTree(BinarySearchTree<T> tree) {
        this.tree = new ArrayList<>();
        this.tree.add(null);

        List<T> list = tree.getTreeAsList();
        for (T value : list) {
            this.insert(value);
        }
    }

    /** insert the given value into the tree */
    public void insert(T value) {
        insert(value, 0, 1);
    }

    /** insert helper function */
    private void insert(T value, int index, int level) {
        reallocate(index, level);

        if (tree.get(index) == null) {
            tree.set(index, value);
            size++;
        }
        else if (value.compareTo(tree.get(index)) < 0) {
            insert(value, leftChild(index), level + 1);
        }
        else if (value.compareTo(tree.get(index)) > 0) {
            insert(value, rightChild(index), level + 1);
        }
    }

    private void reallocate(int index, int level) {
        if (level > height) {
            height = level;
            int nodesToAdd = (int) Math.pow(2, height);
            for (int i = 0; i < nodesToAdd; i++) {
                tree.add(null);
            }
        }
    }

    /** delete the node with the given value */
    public void delete(T value) {
        delete(value, 0);
    }

    /** delete helper function */
    private void delete(T value, int index) {
        if (tree.get(index) == null) {
            return;
        }

        if (value.compareTo(tree.get(index)) < 0) {
            delete(value, leftChild(index));
        }
        else if (value.compareTo(tree.get(index)) > 0) {
            delete(value, rightChild(index));
        }
        // found the node to delete
        else {
            if (tree.get(leftChild(index)) == null && tree.get(rightChild(index)) == null) {
                tree.set(index, null);
                size--;
            }
            else if (tree.get(leftChild(index)) == null) {
                tree.set(index, tree.get(rightChild(index)));
                delete(tree.get(rightChild(index)), rightChild(index));
            }
            else if (tree.get(rightChild(index)) == null) {
                tree.set(index, tree.get(leftChild(index)));
                delete(tree.get(leftChild(index)), leftChild(index));
            }
            else {
                int successorIndex = successor(index);
                tree.set(index, tree.get(successorIndex));
                delete(tree.get(successorIndex), successorIndex);
            }
        }
    }

    /** search for the given value in the tree */
    public int search(T value) {
        return search(value, 0);
    }

    /** search helper function */
    private int search(T value, int index) {
        if (tree.get(index) == null) {
            return -1;
        }
        if (value.compareTo(tree.get(index)) < 0) {
            return search(value, leftChild(index));
        }
        else if (value.compareTo(tree.get(index)) > 0) {
            return search(value, rightChild(index));
        }
        else {
            return index;
        }
    }

    /** get the size of the tree */
    public int countNodes() {
        return size;
    }

    /** returns the size of the array */
    public int size() {
        return tree.size();
    }

    /** returns true if the tree is empty */
    public boolean isEmpty() {
        return size == 0;
    }

    /** returns the maximum value in the tree */
    public T maximum() {
        int current = 0;
        while (tree.get(rightChild(current)) != null) {
            current = rightChild(current);
        }
        return tree.get(current);
    }

    /** returns the minimum value in the tree */
    public T minimum() {
        int current = 0;
        while (tree.get(leftChild(current)) != null) {
            current = leftChild(current);
        }
        return tree.get(current);
    }

    /** print the tree in-order */
    public void inOrder() {
        inOrder(0);
    }

    /** in-order traversal helper function */
    private void inOrder(int index) {
        if (tree.get(index) == null) {
            return;
        }
        inOrder(leftChild(index));
        System.out.println(tree.get(index));
        inOrder(rightChild(index));
    }

    /** print the tree in reverse in-order */
    public void reverseInOrder() {
        reverseInOrder(0);
    }

    /** reverse in-order traversal helper function */
    private void reverseInOrder(int index) {
        if (tree.get(index) == null) {
            return;
        }
        reverseInOrder(rightChild(index));
        System.out.println(tree.get(index));
        reverseInOrder(leftChild(index));
    }



    /** print the tree in pre-order */
    public void preOrder() {
        preOrder(0);
    }

    /** pre-order traversal helper function */
    private void preOrder(int index) {
        if (tree.get(index) == null) {
            return;
        }
        System.out.println(tree.get(index));
        preOrder(leftChild(index));
        preOrder(rightChild(index));
    }

    /** get the tree as a list */
    public List<T> getTreeAsList() {
        List<T> list = new ArrayList<>();
        getTreeAsList(0, list);
        return list;
    }

    /** getTreeAsList helper function */
    private void getTreeAsList(int index, List<T> list) {
        if (tree.get(index) == null) {
            return;
        }
        list.add(tree.get(index));
        getTreeAsList(leftChild(index), list);
        getTreeAsList(rightChild(index), list);
    }

    /** print the tree in post-order */
    public void postOrder() {
        postOrder(0);
    }

    /** post-order traversal helper function */
    private void postOrder(int index) {
        if (tree.get(index) == null) {
            return;
        }
        postOrder(rightChild(index));
        postOrder(leftChild(index));
        System.out.println(tree.get(index));
    }

    /** get successor of the node at the given index */
    public int successor(int index) {
        int successorIndex = rightChild(index);
        while (tree.get(leftChild(successorIndex)) != null) {
            successorIndex = leftChild(successorIndex);
        }
        return successorIndex;
    }

    /** get predecessor of the node at the given index */
    public int predecessor(int index) {
        int predecessorIndex = leftChild(index);
        while (tree.get(rightChild(predecessorIndex)) != null) {
            predecessorIndex = rightChild(predecessorIndex);
        }
        return predecessorIndex;
    }

    /** get the index of the left child of the node at the given index */
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    /** get the index of the right child of the node at the given index */
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int level = 0;
        int nodesAtCurrentLevel = 1;
        int nodesProcessed = 0;

        for (T t : tree) {
            if (nodesProcessed == 0) {
                int tabs = this.height - level;
                sb.append("\t".repeat(Math.max(0, tabs)));
            } else {
                sb.append("\t");
            }

            if (t == null) {
                sb.append("- ");
            } else {
                sb.append(t).append(" ");
            }

            nodesProcessed++;
            if (nodesProcessed == nodesAtCurrentLevel) {
                sb.append("\n");
                level++;
                nodesProcessed = 0;
                nodesAtCurrentLevel *= 2;
            }
        }

        return sb.toString();
    }
}