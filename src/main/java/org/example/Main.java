package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentDAO studentDAO = new StudentDAO();
        CourseDAO courseDAO = new CourseDAO();
        EnrollmentDAO enrollmentDAO = new EnrollmentDAO();
        GradeDAO gradeDAO = new GradeDAO();

        while (true) {
            System.out.println("=== Student Management System ===");
            System.out.println("Please choose an action:");
            System.out.println("1. Student Management");
            System.out.println("2. Course Management");
            System.out.println("3. Enrollment Management");
            System.out.println("4. Grade Management");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    manageStudents(scanner, studentDAO);
                    break;
                case 2:
                    manageCourses(scanner, courseDAO);
                    break;
                case 3:
                    manageEnrollments(scanner, enrollmentDAO);
                    break;
                case 4:
                    manageGrades(scanner, gradeDAO);
                    break;
                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void manageStudents(Scanner scanner, StudentDAO studentDAO) {
        System.out.println("=== Student Management ===");
        System.out.println("1. View all students");
        System.out.println("2. Add a student");
        System.out.println("3. Update a student");
        System.out.println("4. Delete a student");
        System.out.println("5. Back to main menu");
        System.out.print("Enter your choice: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                // View all students
                List<Student> students = studentDAO.getAllStudents();
                if (students.isEmpty()) {
                    System.out.println("No students found.");
                } else {
                    for (Student student : students) {
                        System.out.println("ID: " + student.getId() + ", Name: " + student.getName() +
                                ", Age: " + student.getAge() + ", Email: " + student.getEmail());
                    }
                }
                break;
            case 2:
                // Add a student
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.print("Enter age: ");
                int age = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Enter email: ");
                String email = scanner.nextLine();
                studentDAO.addStudent(new Student(0, name, age, email)); // ID will be auto-generated
                System.out.println("Student added.");
                break;
            case 3:
                // Update a student
                System.out.print("Enter student ID to update: ");
                int updateId = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                System.out.print("Enter new age: ");
                int newAge = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Enter new email: ");
                String newEmail = scanner.nextLine();
                studentDAO.updateStudent(new Student(updateId, newName, newAge, newEmail));
                System.out.println("Student updated.");
                break;
            case 4:
                // Delete a student
                System.out.print("Enter student ID to delete: ");
                int deleteId = scanner.nextInt();
                studentDAO.deleteStudent(deleteId);
                System.out.println("Student deleted.");
                break;
            case 5:
                return; // Back to main menu
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void manageCourses(Scanner scanner, CourseDAO courseDAO) {
        System.out.println("=== Course Management ===");
        System.out.println("1. View all courses");
        System.out.println("2. Add a course");
        System.out.println("3. Update a course");
        System.out.println("4. Delete a course");
        System.out.println("5. Back to main menu");
        System.out.print("Enter your choice: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                // View all courses
                List<Course> courses = courseDAO.getAllCourses();
                if (courses.isEmpty()) {
                    System.out.println("No courses found.");
                } else {
                    for (Course course : courses) {
                        System.out.println("ID: " + course.getId() + ", Name: " + course.getCourseName() +
                                ", Code: " + course.getCourseCode() + ", Credits: " + course.getCredits());
                    }
                }
                break;
            case 2:
                // Add a course
                System.out.print("Enter course name: ");
                String courseName = scanner.nextLine();
                System.out.print("Enter course code: ");
                String courseCode = scanner.nextLine();
                System.out.print("Enter credits: ");
                int credits = scanner.nextInt();
                courseDAO.addCourse(new Course(0, courseName, courseCode, credits)); // ID will be auto-generated
                System.out.println("Course added.");
                break;
            case 3:
                // Update a course
                System.out.print("Enter course ID to update: ");
                int updateCourseId = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Enter new course name: ");
                String newCourseName = scanner.nextLine();
                System.out.print("Enter new course code: ");
                String newCourseCode = scanner.nextLine();
                System.out.print("Enter new credits: ");
                int newCredits = scanner.nextInt();
                courseDAO.updateCourse(new Course(updateCourseId, newCourseName, newCourseCode, newCredits));
                System.out.println("Course updated.");
                break;
            case 4:
                // Delete a course
                System.out.print("Enter course ID to delete: ");
                int deleteCourseId = scanner.nextInt();
                courseDAO.deleteCourse(deleteCourseId);
                System.out.println("Course deleted.");
                break;
            case 5:
                return; // Back to main menu
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void manageEnrollments(Scanner scanner, EnrollmentDAO enrollmentDAO) {
        System.out.println("=== Enrollment Management ===");
        // Similar structure for managing enrollments
        // Implement view, add, update, delete functionalities
    }

    private static void manageGrades(Scanner scanner, GradeDAO gradeDAO) {
        System.out.println("=== Grade Management ===");
        // Similar structure for managing grades
        // Implement view, add, update, delete functionalities
    }
}