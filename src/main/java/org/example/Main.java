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
                    manageEnrollments(scanner, enrollmentDAO, studentDAO, courseDAO); // Pass all required parameters
                    break;
                case 4:
                    manageGrades(scanner, gradeDAO, enrollmentDAO); // Pass all required parameters
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
                // First, display the list of courses
                List<Course> allCourses = courseDAO.getAllCourses();
                if (allCourses.isEmpty()) {
                    System.out.println("No courses available to update.");
                    break;
                }
                System.out.println("Available courses:");
                for (Course course : allCourses) {
                    System.out.println("ID: " + course.getId() + ", Name: " + course.getCourseName());
                }
                System.out.print("Enter course ID to update: ");
                int updateCourseId = scanner.nextInt();
                scanner.nextLine(); // Consume newline
    
                // Check if the course ID exists
                Course courseToUpdate = allCourses.stream()
                    .filter(course -> course.getId() == updateCourseId)
                    .findFirst()
                    .orElse(null);
    
                if (courseToUpdate == null) {
                    System.out.println("Course ID not found. Please try again.");
                    break;
                }
    
                System.out.print("Enter new course name (current: " + courseToUpdate.getCourseName() + "): ");
                String newCourseName = scanner.nextLine();
                System.out.print("Enter new course code (current: " + courseToUpdate.getCourseCode() + "): ");
                String newCourseCode = scanner.nextLine();
                System.out.print("Enter new credits (current: " + courseToUpdate.getCredits() + "): ");
                int newCredits = scanner.nextInt();
                courseDAO.updateCourse(new Course(updateCourseId, newCourseName, newCourseCode, newCredits));
                System.out.println("Course updated.");
                break;
            case 4:
                // Delete a course
                // First, display the list of courses
                List<Course> coursesToDelete = courseDAO.getAllCourses();
                if (coursesToDelete.isEmpty()) {
                    System.out.println("No courses available to delete.");
                    break;
                }
                System.out.println("Available courses:");
                for (Course course : coursesToDelete) {
                    System.out.println("ID: " + course.getId() + ", Name: " + course.getCourseName());
                }
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

    private static void manageEnrollments(Scanner scanner, EnrollmentDAO enrollmentDAO, StudentDAO studentDAO, CourseDAO courseDAO) {
        System.out.println("=== Enrollment Management ===");
        System.out.println("1. View all enrollments");
        System.out.println("2. Add an enrollment");
        System.out.println("3. Delete an enrollment");
        System.out.println("4. Back to main menu");
        System.out.print("Enter your choice: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    
        switch (choice) {
            case 1:
                // View all enrollments
                List<Enrollment> enrollments = enrollmentDAO.getAllEnrollments();
                if (enrollments.isEmpty()) {
                    System.out.println("No enrollments found.");
                } else {
                    for (Enrollment enrollment : enrollments) {
                        System.out.println("ID: " + enrollment.getId() + ", Student ID: " + enrollment.getStudentId() +
                                ", Course ID: " + enrollment.getCourseId());
                    }
                }
                break;
            case 2:
                // Add an enrollment
                System.out.println("Available Students:");
                List<Student> students = studentDAO.getAllStudents();
                for (Student student : students) {
                    System.out.println("ID: " + student.getId() + ", Name: " + student.getName());
                }
                System.out.print("Enter student ID to enroll: ");
                int studentId = scanner.nextInt();
                scanner.nextLine(); // Consume newline
    
                System.out.println("Available Courses:");
                List<Course> courses = courseDAO.getAllCourses();
                for (Course course : courses) {
                    System.out.println("ID: " + course.getId() + ", Name: " + course.getCourseName());
                }
                System.out.print("Enter course ID to enroll in: ");
                int courseId = scanner.nextInt();
                scanner.nextLine(); // Consume newline
    
                enrollmentDAO.addEnrollment(new Enrollment(studentId, courseId));
                System.out.println("Enrollment added.");
                break;
            case 3:
                // Delete an enrollment
                System.out.println("Available Enrollments:");
                List<Enrollment> allEnrollments = enrollmentDAO.getAllEnrollments();
                for (Enrollment enrollment : allEnrollments) {
                    System.out.println("ID: " + enrollment.getId() + ", Student ID: " + enrollment.getStudentId() +
                            ", Course ID: " + enrollment.getCourseId());
                }
                System.out.print("Enter enrollment ID to delete: ");
                int deleteEnrollmentId = scanner.nextInt();
                enrollmentDAO.deleteEnrollment(deleteEnrollmentId);
                System.out.println("Enrollment deleted.");
                break;
            case 4:
                return; // Back to main menu
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void manageGrades(Scanner scanner, GradeDAO gradeDAO, EnrollmentDAO enrollmentDAO) {
        System.out.println("=== Grade Management ===");
        System.out.println("1. View all grades");
        System.out.println("2. Add a grade");
        System.out.println("3. Update a grade");
        System.out.println("4. Delete a grade");
        System.out.println("5. Back to main menu");
        System.out.print("Enter your choice: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    
        List<Grade> allGrades = gradeDAO.getAllGrades(); // Initialize here
    
        switch (choice) {
            case 1:
                // View all grades
                if (allGrades.isEmpty()) {
                    System.out.println("No grades found.");
                } else {
                    for (Grade grade : allGrades) {
                        System.out.println("ID: " + grade.getId() + ", Enrollment ID: " + grade.getEnrollmentId() +
                                ", Grade: " + grade.getGrade());
                    }
                }
                break;
            case 2:
                // Add a grade
                System.out.println("Available Enrollments:");
                List<Enrollment> allEnrollments = enrollmentDAO.getAllEnrollments();
                for (Enrollment enrollment : allEnrollments) {
                    System.out.println("ID: " + enrollment.getId() + ", Student ID: " + enrollment.getStudentId() +
                            ", Course ID: " + enrollment.getCourseId());
                }
                System.out.print("Enter enrollment ID to add a grade: ");
                int enrollmentId = scanner.nextInt();
                System.out.print("Enter the grade: ");
                double gradeValue = scanner.nextDouble();
                gradeDAO.addGrade(new Grade(enrollmentId, gradeValue));
                System.out.println("Grade added.");
                break;
            case 3:
                // Update a grade
                if (allGrades.isEmpty()) {
                    System.out.println("No grades available to update.");
                    break;
                }
                System.out.println("Available Grades:");
                for (Grade grade : allGrades) {
                    System.out.println("ID: " + grade.getId() + ", Enrollment ID: " + grade.getEnrollmentId() +
                            ", Grade: " + grade.getGrade());
                }
                System.out.print("Enter grade ID to update: ");
                int updateGradeId = scanner.nextInt();
                Grade gradeToUpdate = allGrades.stream()
                    .filter(grade -> grade.getId() == updateGradeId)
                    .findFirst()
                    .orElse (null);
    
                if (gradeToUpdate == null) {
                    System.out.println("Grade ID not found. Please try again.");
                    break;
                }
    
                System.out.print("Enter new grade (current: " + gradeToUpdate.getGrade() + "): ");
                double newGradeValue = scanner.nextDouble();
                gradeDAO.updateGrade(new Grade(updateGradeId, gradeToUpdate.getEnrollmentId(), newGradeValue));
                System.out.println("Grade updated.");
                break;
            case 4:
                // Delete a grade
                if (allGrades.isEmpty()) {
                    System.out.println("No grades available to delete.");
                    break;
                }
                System.out.println("Available Grades:");
                for (Grade grade : allGrades) {
                    System.out.println("ID: " + grade.getId() + ", Enrollment ID: " + grade.getEnrollmentId() +
                            ", Grade: " + grade.getGrade());
                }
                System.out.print("Enter grade ID to delete: ");
                int deleteGradeId = scanner.nextInt();
                gradeDAO.deleteGrade(deleteGradeId);
                System.out.println("Grade deleted.");
                break;
            case 5:
                return; // Back to main menu
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}