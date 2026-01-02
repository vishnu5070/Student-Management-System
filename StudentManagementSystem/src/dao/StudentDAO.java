package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Student;
import util.DBConnection;

public class StudentDAO {

    // 1️⃣ ADD STUDENT
    public boolean addStudent(Student student) {
        String sql = "INSERT INTO students (student_id, name, department, email, phone) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, student.getStudentId());
            ps.setString(2, student.getName());
            ps.setString(3, student.getDepartment());
            ps.setString(4, student.getEmail());
            ps.setString(5, student.getPhone());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
            return false;
        }
    }

    // 2️⃣ VIEW ALL STUDENTS
    public void viewStudents() {
        String sql = "SELECT * FROM students";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n--- Student Records ---");
            while (rs.next()) {
                System.out.println(
                    "ID: " + rs.getInt("student_id") +
                    ", Name: " + rs.getString("name") +
                    ", Dept: " + rs.getString("department") +
                    ", Email: " + rs.getString("email") +
                    ", Phone: " + rs.getString("phone")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error viewing students: " + e.getMessage());
        }
    }

    // 3️⃣ UPDATE STUDENT
    public boolean updateStudent(Student student) {
        String sql = "UPDATE students SET name=?, department=?, email=?, phone=? WHERE student_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getDepartment());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getPhone());
            ps.setInt(5, student.getStudentId());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
            return false;
        }
    }

    // 4️⃣ DELETE STUDENT
    public boolean deleteStudent(int studentId) {
        String sql = "DELETE FROM students WHERE student_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, studentId);
            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            System.out.println("Error deleting student: " + e.getMessage());
            return false;
        }
    }
}
