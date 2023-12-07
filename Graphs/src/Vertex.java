import java.util.Arrays;
import java.util.Random;

public class Vertex {
    int[] adjacency;
    int size;
    boolean mark;
    int inDegree;
    int outDegree;
    int weight;
    int cost;
    char path;
    char name;
    boolean known;

    /**
     * Create vertex
     *
     * @param size size of graph
     */
    public Vertex(int size) {
        this(size, (char) ('A' + new Random().nextInt(26)));
    }

    /**
     * Create vertex
     *
     * @param size size of graph
     * @param name name of vertex
     */
    public Vertex(int size, char name) {
        this.size = size;
        this.adjacency = new int[size];
        this.mark = false;
        this.inDegree = 0;
        this.outDegree = 0;
        this.weight = 0;
        this.cost = Integer.MAX_VALUE;
        this.path = 0;
        this.name = name;
        this.known = false;
    }

    /**
     * Sets the weight of an edge at a specified index in the adjacency list.
     *
     * @param index the index in the adjacency list where the edge weight needs to be set
     * @param weight the weight to be set for the edge
     */
    public void setEdge(int index, int weight) {
        this.adjacency[index] = weight;
    }

    /**
     * Retrieves the edge value at a given index in the adjacency list.
     *
     * @param index the index of the edge in the adjacency list
     * @return the edge value at the specified index
     */
    public int getEdge(int index){
        return adjacency[index];
    }

    /**
     * Gets the size of the vertex.
     *
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * Checks if the current vertex is marked.
     *
     * @return true if marked, false otherwise
     */
    public boolean isMarked() {
        return mark;
    }

    /**
     * Sets the mark status of this vertex to true.
     */
    public void setMark() {
        setMark(true);
    }

    /**
     * Sets the mark status of this vertex.
     *
     * @param m the mark status to set
     */
    public void setMark(boolean m) {
        mark = m;
    }

    /**
     * Retrieves the in-degree of the vertex.
     *
     * @return the in-degree of the vertex
     */
    public int getInDegree() {
        return inDegree;
    }

    /**
     * Sets the in-degree of the vertex.
     *
     * @param inDegree the in-degree value to set
     */
    public void setInDegree(int inDegree) {
        this.inDegree = inDegree;
    }

    /**
     * Retrieves the out-degree of the vertex.
     *
     * @return the out-degree of the vertex
     */
    public int getOutDegree() {
        return outDegree;
    }

    /**
     * Sets the out-degree of the vertex.
     *
     * @param outDegree the out-degree value to set
     */
    public void setOutDegree(int outDegree){
        this.outDegree = outDegree;
    }

    /**
     * Calculates the total degree of the vertex by summing its in-degree and out-degree.
     *
     * @return the total degree of the node
     */
    public int getDegree() {
        return inDegree + outDegree;
    }

    /**
     * Retrieves the weight associated of the vertex.
     *
     * @return the weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Sets the weight associated with the vertex.
     *
     * @param weight the weight value to set
     */
    public void setWeight(int weight){
        this.weight = weight;
    }

    /**
     * Provides a string representation of the object.
     * This includes the weight of the vertex and a string representation of its adjacency list.
     *
     * @return A string that combines the weight and the adjacency list of the object.
     */
    @Override
    public String toString(){
        return weight + Arrays.toString(adjacency);
    }
}

