import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Student {
    public String phone;
    public String name;
    public String email;
    public String course;

    /**
     * Create a new student object
     * @param phone: phone number
     * @param name: name
     * @param email: email
     * @param course: course
     */
    public Student(String phone, String name, String email, String course) {
        this.phone = phone;
        this.name = name;
        this.email = email;
        this.course = course;
    }

    /**
     * Read students from CSV file
     * @param fileName: path to CSV file
     * @param limit: limit number of students to read
     * @return List<Student>
     */
    public static List<Student> readStudentsFromCSV(String fileName, int limit) {
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            br.readLine(); // skip the header row
            int count = 0;
            while ((line = br.readLine()) != null && !line.isEmpty() && count < limit) {
                String[] attributes = line.split(",");
                Student student = new Student(attributes[0], attributes[2], attributes[1], attributes[3]);
                students.add(student);
                count++;
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return students;
    }

    /**
     * Read students from CSV file
     * @param fileName: path to CSV file
     * @return List<Student>
     */
    public static List<Student> readStudentsFromCSV(String fileName) {
        return readStudentsFromCSV(fileName, Integer.MAX_VALUE);
    }

    /**
     * Override equals method
     * @param other: another object to compare to
     * @return boolean
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Student student)) return false;
        return this.phone.equals(student.phone) &&
            this.name.equals(student.name) &&
            this.email.equals(student.email) &&
            this.course.equals(student.course);
    }

    /**
     * Override hashCode method
     * @return int
     */
    @Override
    public int hashCode() {
        int prime = 31;
        int result = 17;

        result = prime * result + phone.hashCode();
        result = prime * result + name.hashCode();
        result = prime * result + email.hashCode();
        result = prime * result + course.hashCode();

        return Math.abs(result);
    }

    /**
     * Override toString method
     * @return String
     */
    @Override
    public String toString() {
        return "Student{" +
            "phone='" + phone + '\'' +
            ", name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", course='" + course + '\'' +
            '}';
    }
}
