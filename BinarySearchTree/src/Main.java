public class Main {
    public static void main(String[] args) {
        BinarySearchTree <Point> pointCollection = new BinarySearchTree<>();
        int[] x = { 6, 2, 4, 1, 7, 5, 3 };
        int[] y = { 3, 5, 2, 4, 1, 6, 7 };

        for (int i = 0; i < 7; i++) {
            pointCollection.insert(new Point(x[i], y[i]));
        }
        System.out.println("preOrder traversal of the constructed tree is");
        pointCollection.preOrder();

        System.out.println("Inorder traversal of the constructed tree is");
        pointCollection.inOrder();

        System.out.println("postOrder traversal of the constructed tree is");
        pointCollection.postOrder();

        BinarySearchTree <Point> myPointCollection = new BinarySearchTree<>(pointCollection);
        System.out.println("InOrder traversal of the copied tree is");
        myPointCollection.inOrder();

        Point p = new Point(4, 2);
        System.out.println("The point " + p + " is in the tree at index: " + myPointCollection.search(p));
        System.out.println(myPointCollection);

        myPointCollection.delete(p);
        System.out.println("The tree after deleting " + p + " is");
        System.out.println(myPointCollection);

        System.out.println("Successor of root is: " + myPointCollection.successor(0));
        System.out.println("Predecessor of root is: " + myPointCollection.predecessor(0));

        System.out.println("The node count is: " + myPointCollection.countNodes());
        System.out.println("The size is: " + myPointCollection.size());
        System.out.println("The maximum is: " + myPointCollection.maximum());
        System.out.println("The minimum is: " + myPointCollection.minimum());

        System.out.println("The nodes in ascending order: ");
        myPointCollection.inOrder();

        System.out.println("The nodes in descending order: ");
        myPointCollection.reverseInOrder();
    }
}