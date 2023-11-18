import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class Testing {

    private static void testHasTable(List<Student> students, HashTable table) {
        Random random = new Random();

        System.out.println("Testing " + table.getClass().getName() + " with input size: " + students.size());

        long insertionSteps = 0;
        for (int i = 0; i < students.size(); i++) {
            int index = random.nextInt(students.size() / 2);
            Student studentToInsert = students.get(index);
            insertionSteps += table.insert(studentToInsert);
        }
        System.out.println("insertion: " + insertionSteps);

        long findSteps = 0;
        for (int i = 0; i < students.size(); i++) {
            int index = random.nextInt(students.size());
            Student studentToFind = students.get(index);
            findSteps += table.getSteps(studentToFind);
        }
        System.out.println("find: " + findSteps);
    }


    public static void main(String[] args) {
        final int[] inputSizes = {1000, 2000, 3000, 4000, 5000};
        final int[] tableSizes = {1100, 2100, 3100, 4100, 5100};

        for (int i = 0; i < inputSizes.length; i++) {
            List<Student> students = Student.readStudentsFromCSV("ExportCSV.csv", inputSizes[i]);
            HashTable table = new QuadraticProbing(tableSizes[i]);
            testHasTable(students, table);
        }
    }
}
