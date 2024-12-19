package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GradeDAO {
    public List<Grade> getAllGrades() {
        List<Grade> grades = new ArrayList<>();
        String query = "SELECT * FROM Grades";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int enrollmentId = resultSet.getInt("enrollment_id");
                double grade = resultSet.getDouble("grade");
                grades.add(new Grade(enrollmentId, grade)); // Ensure the constructor matches
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grades;
    }

    public void addGrade(Grade grade) {
        String query = "INSERT INTO Grades (enrollment_id, grade) VALUES (?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, grade.getEnrollmentId());
            preparedStatement.setDouble(2, grade.getGrade());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateGrade(Grade grade) {
        String query = "UPDATE Grades SET grade = ? WHERE enrollment_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, grade.getGrade());
            preparedStatement.setInt(2, grade.getEnrollmentId()); // Assuming you want to update by enrollment ID
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteGrade(int enrollmentId) {
        String query = "DELETE FROM Grades WHERE enrollment_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, enrollmentId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}