package db;

import entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    public static List<Student> getAllActiveStudents() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_42?user=root&password=root");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students WHERE status = 1;");
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setSurname(rs.getString("surname"));
                student.setName(rs.getString("name"));
                student.setGroups(rs.getString("groups"));
                student.setDate(rs.getDate("date"));
                students.add(student);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    public static List<Student> createStudent(String surname, String name, String groups, String date) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_42?user=root&password=root");
            Statement stmt = conn.createStatement();
            stmt.execute("INSERT INTO `students_42`.`students` (`surname`, `name`, `groups`, `date`) VALUES ('"
                + surname + "', '" + name + "', '" + groups + "', '" + date + "');");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    public static List<Student> deleteStudents(int[] id) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_42?user=root&password=root");
            Statement stmt = conn.createStatement();
            for (int i : id) {
                stmt.execute("DELETE FROM `students_42`.`students` WHERE (`id` = '" + i + "');");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return students;
    }
}
