import java.util.ArrayList;
import java.util.LinkedList;


public class Chaining implements HashTable {
    private LinkedList<Student>[] hashTable;
    private int capacity;

    /**
     * Create a new chaining hash table
     * @param capacity: capacity of the hash table
     */
    public Chaining(int capacity) {
        this.capacity = capacity;
        hashTable = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            hashTable[i] = new LinkedList<>();
        }
    }

    /**
     * Hash function
     * @param student: student to hash
     * @return int
     */
    private int hash(Student student) {
        return student.hashCode() % capacity;
    }

    /**
     * Insert a student into the hash table
     * @param student: student to insert
     * @return int number of steps
     */
    public int insert(Student student) {
        int index = hash(student);
        if (hashTable[index] == null) {
            hashTable[index] = new LinkedList<>();
        }
        hashTable[index].add(student);
        return 1;
    }

    /**
     * Find a student from the hash table
     * @param student: student to find
     * @return int number of steps
     */
    public boolean find(Student student) {
        int index = hash(student);
        int i = 0;
        for (Student s : hashTable[index]) {
            if (s.equals(student)) {
                return true;
            }
            i++;
        }
        return false;
    }

    /**
     * Get number of steps to find a student
     * @param student: student to find
     * @return int number of steps
     */
    public int getSteps(Student student) {
        int index = hash(student);
        int i = 0;
        for (Student s : hashTable[index]) {
            if (s.equals(student)) {
                return ++i;
            }
            i++;
        }
        return ++i;
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
            for (Student student : hashTable[i]) {
                sb.append(student).append(" -> ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
