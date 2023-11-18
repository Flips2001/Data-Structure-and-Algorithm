public interface HashTable {
    /**
     * Insert a student into the hash table
     * @param student student to insert
     * @return int number of steps
     */
    public int insert(Student student);

    /**
     * Find a student from the hash table
     * @param student student to find
     * @return int number of steps
     */
    public boolean find(Student student);

    /**
     * Get number of steps to find a student
     * @param student student to find
     * @return int number of steps
     */
    public int getSteps(Student student);

    /**
     * Override toString method
     * @return String
     */
    @Override
    public String toString();
}
