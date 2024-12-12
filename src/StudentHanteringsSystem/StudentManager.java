package StudentHanteringsSystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StudentManager {
    private static StudentManager instance;
    private Map<String, Student> students;

    private StudentManager() {
        students = new HashMap<>();
    }

    public static StudentManager getInstance() {
        if (instance == null) {
            instance = new StudentManager();
        }
        return instance;
    }

    public void addStudent(String id, String name, String grade) {
        if (!students.containsKey(id)) {
            students.put(id, new Student(id, name, grade));
            System.out.println("Student added successfully. ");
        } else {
            System.out.println("Student already exists. ");
        }
    }

    public void saveToFile(String fileName) {
        FileWriter writer;
        try {
            writer = new FileWriter(fileName);

            for (Student student : students.values()) {
                writer.write(student.getId() + "," + student.getName() + "," + student.getGrade());
                writer.write("\n");
            }
            writer.close();
            System.out.println("Student saved to file successfully");
        } catch (IOException e) {
            System.out.println("Error while saving to file: " + e.getMessage());
        }
    }

    public void loadFromFile(String fileName){
        Map<String, Student> students = new HashMap<>();
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length == 3) {
                    String id = tokens[0].trim();
                    String name = tokens[1].trim();
                    String grade = tokens[2].trim();
                    students.put(id, new Student(id, name, grade));
                }
            }

            System.out.println("Student loaded from file successfully");
        } catch (IOException e) {
            System.out.println("Error while loading from file: " + e.getMessage());
        }
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("There is no students in the database");
        } else {
            for (Student student : students.values()) {
                System.out.println(student);
            }
        }
    }

    public void searchStudentById(String id) {
        Student student = students.get(id);
        if (student != null) {
            System.out.println("Student found: " + student);
        } else {
            System.out.println("Student with ID: " + id + " not found.");
        }
    }
}