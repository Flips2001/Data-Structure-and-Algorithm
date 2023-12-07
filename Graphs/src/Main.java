import java.util.Random;

public class Main {
    public static void main(String[] args) {

        System.out.println("Topological Sort");
        testTopologicalSort();

        System.out.println("DFS");
        testDFS();

        System.out.println("BFS");
        testBFS();

        System.out.println("Dijkstra's Sort");
        testDijkstra();
    }

    /*
     * test topological sort algorithm
     */
    private static void testTopologicalSort() {
        Graph graph = new Graph();
        graph.topologicalSort();
    }

    /*
     * test DFS algorithm
     */
    private static void testDFS() {
        int size = 8;
        Vertex[] V = {new Vertex(size, 'A'), new Vertex(size, 'B'), new Vertex(size, 'C'), new Vertex(size, 'D'), new Vertex(size, 'E'), new Vertex(size, 'F'), new Vertex(size, 'G'), new Vertex(size, 'H')};
        for (int i = 0; i < 8; i++){
            V[i].weight = i;
        }
        V[0].setEdge(1, 2);
        V[0].setEdge(2, 1);
        V[1].setEdge(3, 5);
        V[1].setEdge(4, 5);
        V[2].setEdge(5, 1);
        V[5].setEdge(6, 10);
        V[5].setEdge(7, 10);

        Graph graph = new Graph(V);
        graph.DFS(V[0]);
    }

    /*
     * test BFS algorithm
     */
    private static void testBFS() {
        int size = 8;
        Vertex[] V = {new Vertex(size, 'A'), new Vertex(size, 'B'), new Vertex(size, 'C'), new Vertex(size, 'D'), new Vertex(size, 'E'), new Vertex(size, 'F'), new Vertex(size, 'G'), new Vertex(size, 'H')};
        for (int i = 0; i < 8; i++){
            V[i].weight = i;
        }
        V[0].setEdge(1, 2);
        V[0].setEdge(2, 1);
        V[1].setEdge(3, 5);
        V[1].setEdge(4, 5);
        V[2].setEdge(5, 1);
        V[5].setEdge(6, 10);
        V[5].setEdge(7, 10);

        Graph graph = new Graph(V);
        graph.BFS(V[0]);
    }

    /*
     * test Dijkstra's sort algorithm
     */
    private static void testDijkstra() {
        int size = 8;

        Vertex[] V = {
                new Vertex(size, 'A'),
                new Vertex(size, 'B'),
                new Vertex(size, 'C'),
                new Vertex(size, 'D'),
                new Vertex(size, 'E'),
                new Vertex(size, 'F'),
                new Vertex(size, 'G'),
                new Vertex(size, 'H')
        };

        V[0].setEdge(1, 2); // A -> B
        V[0].setEdge(2, 1); // A -> C
        V[0].setEdge(3, 4); // A -> D

        V[1].setEdge(2, 5); // B -> C
        V[1].setEdge(5, 2); // B -> F

        V[2].setEdge(4, 11); // C -> E
        V[2].setEdge(0, 9); // C -> A

        V[3].setEdge(2, 2); // D -> C

        V[4].setEdge(3, 7); // E -> D
        V[4].setEdge(6, 1); // E -> G

        V[5].setEdge(7, 3); // F -> H

        V[6].setEdge(4, 3); // G -> E
        V[6].setEdge(5, 2); // G -> F

        V[7].setEdge(6, 1); // H -> G

        Graph graph = new Graph(V);

        graph.dijkstra(V[0]);
    }
}
