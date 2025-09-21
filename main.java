import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n--- Student Manager ---");
            System.out.println("1 - Add Student");
            System.out.println("2 - List Students");
            System.out.println("3 - Show Average GPA");
            System.out.println("4 - Show Honor Students");
            System.out.println("5 - Remove Student by ID");
            System.out.println("0 - Exit");
            System.out.print("Enter choice: ");
            option = input.nextInt();

            switch (option) {
                case 1:
                    input.nextLine();
                    System.out.print("Enter name: ");
                    String name = input.nextLine();

                    System.out.print("Enter id: ");
                    int id = input.nextInt();

                    System.out.print("Enter gpa: ");
                    double gpa = input.nextDouble();

                    Student s = new Student(name, id, gpa);
                    students.add(s);
                    System.out.println("Student added successfully");
                    break;

                case 2:
                    System.out.println("--- All Students ---");
                    if (students.isEmpty()) {
                        System.out.println("No students yet!");
                    } else {
                        for (Student st : students) {
                            System.out.println(st);
                        }
                    }
                    break;

                case 3:
                    System.out.println("--- Average GPA ---");
                    if (students.isEmpty()) {
                        System.out.println("No students yet!");
                        break;
                    }
                    double sum = 0;
                    for (Student st : students) {
                        sum += st.getGpa();
                    }
                    double avg = sum / students.size();
                    System.out.printf("Average GPA: %.2f%n", avg);
                    break;

                case 4:
                    System.out.println("--- Honor Students (GPA >= 3.5) ---");
                    if (students.isEmpty()) {
                        System.out.println("No students yet!");
                        break;
                    }
                    boolean found = false;
                    for (Student st : students) {
                        if (st.getGpa() >= 3.5) {
                            System.out.println(st);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("No honor students.");
                    }
                    break;

                case 5:
                    System.out.println("--- Remove Student by ID ---");
                    if (students.isEmpty()) {
                        System.out.println("No students yet!");
                        break;
                    }
                    System.out.print("Enter ID to remove: ");
                    int removeId = input.nextInt();
                    boolean removed = false;
                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).getId() == removeId) {
                            students.remove(i);
                            removed = true;
                            System.out.println("Student removed.");
                            break;
                        }
                    }
                    if (!removed) {
                        System.out.println("Student with ID " + removeId + " not found.");
                    }
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (option != 0);

        input.close();
    }
}
