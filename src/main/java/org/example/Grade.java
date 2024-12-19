package org.example;

public class Grade {
    private int id; // This might be auto-generated by the database
    private int enrollmentId; // This links to the enrollment
    private double grade; // The actual grade value

    // Constructor for creating a new Grade without an ID
    public Grade(int enrollmentId, double grade) {
        this.enrollmentId = enrollmentId;
        this.grade = grade;
    }

    // Constructor for creating a Grade with an ID (e.g., when retrieving from the database)
    public Grade(int id, int enrollmentId, double grade) {
        this.id = id;
        this.enrollmentId = enrollmentId;
        this.grade = grade;
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getEnrollmentId() {
        return enrollmentId;
    }

    public double getGrade() {
        return grade;
    }

    // Optionally, you can add setters if you need to modify these fields
    public void setId(int id) {
        this.id = id;
    }

    public void setEnrollmentId(int enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}