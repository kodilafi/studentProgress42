package controllers;

import db.DBManager;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@WebServlet(name = "StudentCreateControllers", urlPatterns = "/students-create")
public class StudentsCreateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/students-create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String surname = req.getParameter("surname");
        String name = req.getParameter("name");
        String groups = req.getParameter("groups");
        String date = req.getParameter("date");

        if (surname == null || surname.trim().isEmpty() || name == null || name.trim().isEmpty() ||
                groups == null || groups.trim().isEmpty() || date == null || date.trim().isEmpty()) {
            req.setAttribute("message", 1);
            req.getRequestDispatcher("WEB-INF/students-create.jsp").forward(req, resp);
            return;
        }

        DateFormat format = new SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH);
        Date object = null;
        try {
            object = format.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException();
        }

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTimeToDb = formatter.format(object);

        DBManager.createStudent(surname, name, groups, dateTimeToDb);
        resp.sendRedirect("/students");
    }
}

