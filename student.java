import java.util.*;

// Student class to store student details
class Student {
    int id;
    String name;
    String rollNumber;
    
    public Student(int id, String name, String rollNumber) {
        this.id = id;
        this.name = name;
        this.rollNumber = rollNumber;
    }
}

// Attendance class to mark and view attendance
class Attendance {
    Map<String, List<String>> attendanceRecords = new HashMap<>();
    
    // Mark attendance
    public void markAttendance(String date, String rollNumber) {
        attendanceRecords.putIfAbsent(date, new ArrayList<>());
        attendanceRecords.get(date).add(rollNumber);
        System.out.println("Attendance marked for " + rollNumber + " on " + date);
    }
    
    // View attendance
    public void viewAttendance(String date) {
        if (attendanceRecords.containsKey(date)) {
            System.out.println("Attendance on " + date + ": " + attendanceRecords.get(date));
        } else {
            System.out.println("No attendance records found for " + date);
        }
    }
}

// Main class
public class StudentAttendanceSystem {
    static Scanner scanner = new Scanner(System.in);
    static List<Student> students = new ArrayList<>();
    static Attendance attendance = new Attendance();
    
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Student\n2. Mark Attendance\n3. View Attendance\n4. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    markAttendance();
                    break;
                case 3:
                    viewAttendance();
                    break;
                case 4:
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
    
    public static void addStudent() {
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Roll Number: ");
        String rollNumber = scanner.nextLine();
        int id = students.size() + 1;
        students.add(new Student(id, name, rollNumber));
        System.out.println("Student Added Successfully!");
    }
    
    public static void markAttendance() {
        System.out.print("Enter Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.print("Enter Roll Number: ");
        String rollNumber = scanner.nextLine();
        attendance.markAttendance(date, rollNumber);
    }
    
    public static void viewAttendance() {
        System.out.print("Enter Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        attendance.viewAttendance(date);
    }
}
