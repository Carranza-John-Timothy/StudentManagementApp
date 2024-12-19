package org.example;

public class Grade {
    private int id;
    private int enrollmentId;
    private double grade;

    // Constructor
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
}
