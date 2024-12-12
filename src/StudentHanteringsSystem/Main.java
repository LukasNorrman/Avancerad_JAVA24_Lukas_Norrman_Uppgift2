package StudentHanteringsSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = StudentManager.getInstance();
        String filename = "students.txt";
        boolean running = true;

        while (running) {
            System.out.print("\n-- StudentManagementSystem -- ");
            System.out.print("\n1. Add Student");
            System.out.print("\n2. Save student to file");
            System.out.print("\n3. Load student from file");
            System.out.print("\n4. Search student by ID");
            System.out.print("\n5. Display all students");
            System.out.print("\n6. Exit");
            System.out.print("\nEnter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter student Grade: ");
                    String grade = sc.nextLine();
                    manager.addStudent(id, name, grade);
                    break;
                case 2:
                    manager.saveToFile(filename);
                    break;
                case 3:
                    manager.loadFromFile(filename);
                    break;
                case 4:
                    System.out.print("Enter student ID to search: ");
                    String searchId = sc.nextLine();
                    manager.searchStudentById(searchId);
                    break;
                case 5:
                    manager.displayAllStudents();
                    break;
                case 6:
                    System.out.print("Exiting the program. Goodbye! ");
                    sc.close();
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}