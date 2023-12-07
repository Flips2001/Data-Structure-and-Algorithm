import java.util.*;

public class Graph {

    Vertex[] graph;

    /**
     * Constructs a Graph with a random size between 10 and 5000 vertices.
     */
    public Graph() {
        this(new Random().nextInt(10, 5000));
    }

    /**
     * Constructs a Graph using an array of vertices.
     *
     * @param graph The array of vertices to initialize the graph.
     */
    public Graph(Vertex[] graph) {
        this.graph = graph;
    }

    /**
     * Constructs a Graph with a specified size and a default spareness of 0.5.
     *
     * @param size The number of vertices in the graph.
     */
    Graph(int size) {
        this(size, 0.5);
    }

    /**
     * Constructs a Graph with a specified size and spareness.
     * Initializes vertices and randomly assigns weights and connections based on the spareness.
     *
     * @param size      The number of vertices in the graph.
     * @param spareness The probability of creating an edge between two vertices.
     */
    public Graph(int size, double spareness) {
        Random random = new Random(3);
        int N = size;
        Vertex[] graph = new Vertex[N];

        for (int i = 0; i < N; i++) {
                graph[i] = new Vertex(N);
        }


        // Assign random weights and connections
        for (int i = 0; i < N; i++) {
            Vertex v = graph[i];

            for (int k = i + 1; k < N; k++) { // Ensure k is always greater than i, there are no cycles
                if (random.nextDouble() < spareness) {
                    int weight = random.nextInt(100) + 1;
                    v.setEdge(k, weight);
                    v.setOutDegree(v.getOutDegree() + 1);

                    Vertex connectedVertex = graph[k];
                    connectedVertex.setInDegree(connectedVertex.getInDegree() + 1);
                }
            }

            v.weight = random.nextInt(100);
        }
    this.graph = graph;
    }

    /**
     * Retrieves adjacent vertices for a given vertex based on its adjacency list.
     *
     * @param adjacent The adjacency list of the vertex.
     * @return A list of adjacent vertices.
     */
    private ArrayList<Vertex> getAdjacentVertices(int[] adjacent) {
        ArrayList<Vertex> adjacentVertices = new ArrayList<>();
        for (int i = 0; i < adjacent.length; i++) {
            if (adjacent[i] > 0) {
                adjacentVertices.add(graph[i]);
            }
        }
        return adjacentVertices;
    }


    /**
     * Performs a topological sort on the graph and prints the result.
     */
    public void topologicalSort() {
        ArrayList<Integer> output = new ArrayList<>();
        Queue<Vertex> queue = new LinkedList<>();
        for (Vertex vertex : graph) {
            if (vertex.inDegree == 0) {
                queue.add(vertex);
            }
        }

        while(!queue.isEmpty()) {
            Vertex v = queue.remove();
            output.add(v.weight);
            ArrayList<Vertex> adjacentVertices = getAdjacentVertices(v.adjacency);

            for (Vertex adj : adjacentVertices) {
                adj.setInDegree(adj.inDegree - 1);

                if (adj.inDegree == 0) {
                    queue.add(adj);
                }
            }
        }
        System.out.println(output);
    }

    /**
     * Performs a depth-first search (DFS) starting from a given vertex and prints the result.
     *
     * @param startVertex The vertex from which DFS starts.
     */
    public void DFS(Vertex startVertex) {
        if (startVertex == null) {return;}

        ArrayList<Character> output = new ArrayList<>();
        Stack<Vertex> stack = new Stack<>();
        stack.push(startVertex);
        startVertex.setMark();

        while (!stack.isEmpty()) {
            Vertex next = stack.pop();
            output.add(next.name);
            ArrayList<Vertex> adjacentVertices = getAdjacentVertices(next.adjacency);

            for (Vertex v : adjacentVertices) {
                if (!v.isMarked()) {
                    v.setMark();
                    stack.push(v);
                }
            }

        }
        System.out.println(output);
    }

    /**
     * Performs a breadth-first search (BFS) starting from a given vertex and prints the result.
     *
     * @param startVertex The vertex from which BFS starts.
     */
    public void BFS(Vertex startVertex){
        if (startVertex == null) return;

        ArrayList<Character> output = new ArrayList<>();
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(startVertex);
        startVertex.setMark();

        while (!queue.isEmpty()) {
            Vertex next = queue.remove();
            output.add(next.name );
            ArrayList<Vertex> adjacentVertices = getAdjacentVertices(next.adjacency);

            for (Vertex v : adjacentVertices) {
                if (!v.isMarked()) {
                    v.setMark();
                    queue.add(v);
                }
            }
        }
        System.out.println(output);
    }

    /**
     * Performs Dijkstra's algorithm starting from a given vertex.
     *
     * @param start The starting vertex for Dijkstra's algorithm.
     */
    public void dijkstra(Vertex start) {
        if (start == null) return;

        start.cost = 0;
        PriorityQueue<Vertex> queue = new PriorityQueue<>(Comparator.comparingInt(v -> v.cost));
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex b = queue.remove();
            b.known = true;

            for (int i = 0; i < b.adjacency.length; i++) {
                if (b.adjacency[i] == 0) continue;
                Vertex a = graph[i];
                int edgeWeight = b.adjacency[i];
                if (!a.known) {
                    if (b.cost + edgeWeight < a.cost) {
                        queue.remove(a);
                        a.cost = b.cost + edgeWeight;
                        a.path = b.name;
                        queue.add(a);
                    }
                }
            }
        }
        printShortestPaths(start);
    }

    /**
     * Prints the shortest paths from a source vertex to all other vertices in the graph.
     *
     * @param source The source vertex.
     */
    public void printShortestPaths(Vertex source) {
        for (Vertex v : graph) {
            if (v != source && v.cost < Integer.MAX_VALUE) {
                printPath(source, v);
                System.out.println(" (" + v.cost + ")");
            }
        }
    }

    /**
     * Prints the shortest path from a source vertex to a target vertex.
     *
     * @param source The source vertex.
     * @param target The target vertex.
     */
    private void printPath(Vertex source, Vertex target) {
        if (target == source) {
            System.out.print(source.name);
        } else if (target.path == 0) {
            System.out.print("No path");
        } else {
            printPath(source, findVertexByName(target.path));
            System.out.print(" " + target.name);
        }
    }

    /**
     * Finds a vertex by its name.
     *
     * @param name The name of the vertex to find.
     * @return The vertex with the specified name, or null if not found.
     */
    private Vertex findVertexByName(char name) {
        for (Vertex v : graph) {
            if (v.name == name) {
                return v;
            }
        }
        return null;
    }

    /**
     * Provides a string representation of the Graph.
     *
     * @return A string that represents the Graph and its connections.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < graph.length; i++) {
            sb.append("Vertex ").append(i).append(" (").append(graph[i].name).append(")").append(": ");
            for (int j = 0; j < graph[i].getSize(); j++) {
                int weight = graph[i].getEdge(j);
                if (weight != 0) {
                    sb.append("(").append(j).append(", ").append(weight).append(") ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
