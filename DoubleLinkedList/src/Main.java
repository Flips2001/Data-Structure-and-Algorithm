
public class Main {
    public static void main(String[] args) {
        DoubleLinkedList<Movie> movCollection = new DoubleLinkedList<>();
        movCollection.pushBack(new Movie("The Shawshank Redemption", "Frank Darabont", 1994));
        movCollection.pushBack(new Movie("The Godfather", "Francis Ford Coppola", 1972));
        movCollection.pushBack(new Movie("The Godfather: Part II", "Francis Ford Coppola", 1974));
        movCollection.pushBack(new Movie("The Dark Knight", "Christopher Nolan", 2008));
        movCollection.pushBack(new Movie("Inception", "Christopher Nolan", 2010));
        movCollection.pushBack(new Movie("Forrest Gump", "Robert Zemeckis", 1994));
        movCollection.pushBack(new Movie("Fight Club", "David Fincher", 1999));
        movCollection.pushBack(new Movie("Titanic", "James Cameron", 1997));
        movCollection.pushBack(new Movie("Interstellar", "Christopher Nolan", 2014));
        movCollection.pushBack(new Movie("The Matrix", "The Wachowski Siblings", 1999));
        movCollection.displayList();

        DoubleLinkedList<Movie> myMovCollection = movCollection.copy();
        myMovCollection.displayList();

        movCollection.reverseList();
        movCollection.displayList();

        Movie movie = new Movie("The Matrix", "The Wachowski Siblings", 1999);
        movCollection.search(movie).forEach(index -> System.out.println("Found at index: " + index));

        movCollection.deleteItem(movie);
        movCollection.displayList();
    }
}