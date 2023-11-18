public class DoubleHashing implements HashTable {
    private Student[] hashTable;
    private final int capacity;

    /**
     * Create a new double hashing hash table
     * @param capacity capacity of the hash table
     */
    public DoubleHashing(int capacity) {
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
     * Calculate the second hash value of a student
     * @param student student to hash
     * @return int hash value
     */
    private int hash2(Student student) {
        return 313 - (student.hashCode() % 313);
    }

    /**
     * Insert a student into the hash table
     * @param student student to insert
     * @return int number of steps
     */
    public int insert(Student student) {
        int index = hash(student);
        int i = 1;
        while (hashTable[index] != null) {
            index = Math.abs((hash(student) + i * hash2(student)) % capacity);
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
            index = Math.abs((hash(student) + i * hash2(student)) % capacity);
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
            index = Math.abs((hash(student) + i * hash2(student)) % capacity);
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
