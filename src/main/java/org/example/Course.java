package org.example;

public class Course {
    private int id;
    private String courseName;
    private String courseCode;
    private int credits;

    // Constructor
    public Course(int id, String courseName, String courseCode, int credits) {
        this.id = id;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.credits = credits;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public int getCredits() {
        return credits;
    }
}
