public class LinearProbing implements HashTable {
    private Student[] hashTable;
    private final int capacity;

    /**
     * Create a new linear probing hash table
     * @param capacity capacity of the hash table
     */
    public LinearProbing(int capacity) {
        this.capacity = capacity;
        hashTable = new Student[capacity];
    }

    /**
     * Calculate the hash value of a student
     * @param student student to hash
     * @return int hash value
     */
    private int hash(Student student) {
        return student.hashCode() % capacity;
    }

    /**
     * Insert a student into the hash table
     * @param student student to insert
     * @return int number of steps
     */
    public int insert(Student student) {
        int index = hash(student);
        int i = 0;
        while (hashTable[index] != null) {
            index = (hash(student) + i) % capacity;
            i++;
        }
        hashTable[index] = student;
        return i;
    }

    /**
     * Find a student from the hash table
     * @param student student to find
     * @return int number of steps
     */
    public boolean find(Student student) {
        int index = hash(student);
        int i = 0;
        while (hashTable[index] != null) {
            if (hashTable[index].equals(student)) {
                return true;
            }
            index = (hash(student) + i) % capacity;
            i++;
        }
        return false;
    }

    /**
     * Get number of steps to find a student
     * @param student student to find
     * @return int number of steps
     */
    public int getSteps(Student student) {
        int index = hash(student);
        int i = 0;
        while (hashTable[index] != null) {
            if (hashTable[index].equals(student)) {
                return ++i;
            }
            index = (hash(student) + i) % capacity;
            i++;
        }
        return i;
    }

    /**
     * Override toString method
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < capacity; i++) {
            sb.append(i).append(": ");
            if (hashTable[i] != null) {
                sb.append(hashTable[i]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
