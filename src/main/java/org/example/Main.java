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
            System.out.println("Choose an action:");
            System.out.println("1. View all students");
            System.out.println("2. Add a student");
            System.out.println("3. Update a student");
            System.out.println("4. Delete a student");
            System.out.println("5. View all courses");
            System.out.println("6. Add a course");
            System.out.println("7. Update a course");
            System.out.println("8. Delete a course");
            System.out.println("9. View all enrollments");
            System.out.println("10. Add an enrollment");
            System.out.println("11. Delete an enrollment");
            System.out.println("12. View all grades");
            System.out.println("13. Add a grade");
            System.out.println("14. Update a grade");
            System.out.println("15. Delete a grade");
            System.out.println("16. Exit");
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
                case 6:
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
                case 7:
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
                case 8:
                    // Delete a course
                    System.out.print("Enter course ID to delete: ");
                    int deleteCourseId = scanner.nextInt();
                    courseDAO.deleteCourse(deleteCourseId);
                    System.out.println("Course deleted.");
                    break;
                case 9:
                    // View all enrollments
                    List<Enrollment> enrollments = enrollmentDAO.getAllEnrollments();
                    if (enrollments.isEmpty()) {
                        System.out.println("No enrollments found.");
                    } else {
                        for (Enrollment enrollment : enrollments) {
                            System.out.println("Student ID: " + enrollment.getStudentId() + ", Course ID: " + enrollment.getCourseId());
                        }
                    }
                    break;
                case 10:
                    // Add an enrollment
                    // Adding an enrollment
                    System.out.print("Enter student ID: ");
                    int studentId = scanner.nextInt();
                    System.out.print("Enter course ID: ");
                    int courseId = scanner.nextInt();
                    enrollmentDAO.addEnrollment(new Enrollment(studentId, courseId)); // Use the correct constructor
                case 11:
                    // Delete an enrollment
                    System.out.print("Enter student ID to delete enrollment: ");
                    int enrollmentStudentId = scanner.nextInt();
                    System.out.print("Enter course ID to delete enrollment: ");
                    int enrollmentCourseId = scanner.nextInt();
                    enrollmentDAO.deleteEnrollment(enrollmentStudentId, enrollmentCourseId);
                    System.out.println("Enrollment deleted.");
                    break; 
                case 12:
                    // View all grades
                    List<Grade> grades = gradeDAO.getAllGrades();
                    if (grades.isEmpty()) {
                        System.out.println("No grades found.");
                    } else {
                        for (Grade grade : grades) {
                            System.out.println("Enrollment ID: " + grade.getEnrollmentId() + ", Grade: " + grade.getGrade());
                        }
                    }
                    break;
                case 13:
                    // Add a grade
                    System.out.print("Enter enrollment ID: ");
                    int enrollmentId = scanner.nextInt();
                    System.out.print("Enter grade: ");
                    double gradeValue = scanner.nextDouble(); // Ensure this is a double
                    gradeDAO.addGrade(new Grade(enrollmentId, gradeValue)); // Use the correct constructor
                    System.out.println("Grade added.");
                    break;
                case 14:
                    // Update a grade
                    System.out.print("Enter enrollment ID to update grade: ");
                    int updateEnrollmentId = scanner.nextInt();
                    System.out.print("Enter new grade: ");
                    double newGradeValue = scanner.nextDouble(); // Ensure this is a double
                    gradeDAO.updateGrade(new Grade(updateEnrollmentId, newGradeValue)); // Use the correct constructor
                    System.out.println("Grade updated.");
                    break;
                case 15:
                    // Delete a grade
                    System.out.print("Enter enrollment ID to delete grade: ");
                    int deleteEnrollmentId = scanner.nextInt();
                    gradeDAO.deleteGrade(deleteEnrollmentId); // Call with a single parameter
                    System.out.println("Grade deleted.");
                    break;
                case 16:
                    // Exit
                    System.out.println("Exiting the application.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}