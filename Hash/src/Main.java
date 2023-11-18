import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Student.readStudentsFromCSV("ExportCSV.csv", 100);
        Student notStoredStudent = new Student("123456789", "Nguyen Van A", "test", "test");

        // Test DoubleHashing
        DoubleHashing doubleHashing = new DoubleHashing(127);
        for (Student student : students) {
            doubleHashing.insert(student);
        }
        //System.out.println(doubleHashing);
        System.out.println(doubleHashing.find(students.get(99)));
    }
}