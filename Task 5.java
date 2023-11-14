//JAISURYAH K P
//Student Course registration System

import java.util.ArrayList;
import java.util.Scanner;

class Course {
    String code;
    String title;
    String description;
    int capacity;
    String schedule;
    ArrayList<Student> registeredStudents;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.registeredStudents = new ArrayList<>();
    }
}

class Student {
    int id;
    String name;
    ArrayList<Course> registeredCourses;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }
}

class StudentCourseRegistrationSystem {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Course> courses = new ArrayList<>();
    static int studentIDCounter = 1;
    static int courseIDCounter = 1;

    public static void addCourse() {
        System.out.print("Enter the course code: ");
        String code = sc.nextLine();
        System.out.print("Enter the course title: ");
        String title = sc.nextLine();
        System.out.print("Enter the course description: ");
        String description = sc.nextLine();
        System.out.print("Enter the capacity of the course: ");
        int capacity = sc.nextInt();
        sc.nextLine(); // Consume the newline
        System.out.print("Enter the schedule of the course: ");
        String schedule = sc.nextLine();

        Course course = new Course(code, title, description, capacity, schedule);
        courses.add(course);
        System.out.println("Course added successfully!");
    }

    public static void displayCourses() {
        System.out.println("Available Courses:");
        System.out.println("Code\tTitle\tCapacity\tSchedule");
        for (Course course : courses) {
            System.out.println(course.code + "\t" + course.title + "\t" + (course.capacity - course.registeredStudents.size()) + "\t" + course.schedule);
        }
        System.out.println();
    }

    public static void registerStudentForCourse() {
        displayCourses();
        System.out.print("Enter student ID: ");
        int studentID = sc.nextInt();
        sc.nextLine(); // Consume the newline1

        if (studentID >= 1 && studentID <= students.size()) {
            Student student = students.get(studentID - 1);

            System.out.print("Enter course code to register: ");
            String courseCode = sc.nextLine();

            for (Course course : courses) {
                if (course.code.equals(courseCode) && course.registeredStudents.size() < course.capacity) {
                    student.registeredCourses.add(course);
                    course.registeredStudents.add(student);
                    System.out.println(student.name + " has been registered for " + course.title);
                    return;
                }
            }

            System.out.println("Invalid course code or the course is full.");
        } else {
            System.out.println("Invalid student ID.");
        }
    }

    public static void removeStudentFromCourse() {
        System.out.print("Enter student ID: ");
        int studentID = sc.nextInt();
        sc.nextLine(); // Consume the newline

        if (studentID >= 1 && studentID <= students.size()) {
            Student student = students.get(studentID - 1);

            System.out.print("Enter course code to remove: ");
            String courseCode = sc.nextLine();

            for (Course course : student.registeredCourses) {
                if (course.code.equals(courseCode)) {
                    student.registeredCourses.remove(course);
                    course.registeredStudents.remove(student);
                    System.out.println(student.name + " has been removed from " + course.title);
                    return;
                }
            }

            System.out.println("Student is not registered for the specified course.");
        } else {
            System.out.println("Invalid student ID.");
        }
    }

    public static void addStudent() {
        System.out.print("Enter the name of the student: ");
        String name = sc.nextLine();

        Student student = new Student(studentIDCounter++, name);
        students.add(student);

        System.out.println("Student added successfully! Student ID: " + student.id);
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println();
            System.out.println("1. Add a course");
            System.out.println("2. Display available courses");
            System.out.println("3. Register a student for a course");
            System.out.println("4. Remove a student from a course");
            System.out.println("5. Add a student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    addCourse();
                    break;
                case 2:
                    displayCourses();
                    break;
                case 3:
                    registerStudentForCourse();
                    break;
                case 4:
                    removeStudentFromCourse();
                    break;
                case 5:
                    addStudent();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Enter a valid choice.");
            }
        }
    }
}
