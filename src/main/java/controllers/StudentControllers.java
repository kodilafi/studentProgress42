package controllers;

import db.DBManager;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (name = "StudentControllers", urlPatterns = "/students")
public class StudentControllers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> studentList = DBManager.getAllActiveStudents();
        req.setAttribute("students", studentList);
        req.getRequestDispatcher("WEB-INF/students.jsp").forward(req, resp);
    }
}
