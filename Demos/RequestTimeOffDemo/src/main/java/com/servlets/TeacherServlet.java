package com.servlets;


import com.Persistance.Teacher;
import com.Persistance.TeacherDAO;
import com.Utils.CurrentUser;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TeacherServlet extends HttpServlet {


    CurrentUser currentUser;
    TeacherDAO teacherDAO = new TeacherDAO();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        //here we want to reach the database using our servlet
        //this get method is only every getting one teacher
//
//        System.out.println("This method was just invoked by the ");
//        Integer id = Integer.parseInt(req.getParameter("teacherID"));
//            Teacher teacher = teacherDAO.read(id);
//
//           resp.getWriter().print(teacher.getEmail());
//            System.out.println(resp.getStatus());
//            resp.getWriter().println(req.getAttribute("request-state"));

    String email = String.valueOf(req.getParameter("email-sign-in"));
    String password = String.valueOf(req.getParameter("password-sign-in"));

    CurrentUser.setUser(teacherDAO.loginCurrentTeacher(email, password));

    if (CurrentUser.getUser() == null){
        req.getRequestDispatcher("error-page.html").forward(req,resp);
    } else {
        req.getRequestDispatcher("requests.html").forward(req, resp);
    }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);

//        ObjectMapper mapper = new ObjectMapper();
//       Teacher teacher = mapper.readValue(req.getInputStream(),Teacher.class);
//        String email = String.valueOf(req.getParameter("email-input"));
//        String password = String.valueOf(req.getParameter("password-input"));
//        teacherDAO.create(teacher);
//      CurrentUser.setUser(teacherDAO.loginCurrentTeacher(email,password));


        String firstName = String.valueOf(req.getParameter("fName-sign-up"));
        String lastName = String.valueOf(req.getParameter("lName-sign-up"));
        String email = String.valueOf(req.getParameter("email-sign-up"));
        String password = String.valueOf(req.getParameter("password-sign-up"));
        Integer principalID = Integer.parseInt(req.getParameter("prinId-sign-up"));



       Teacher teacher = new Teacher(firstName,lastName,email,password,principalID);

        teacherDAO.create(teacher);
        resp.setStatus(203);
//        resp.getWriter().println(currentUser.getUserId());
//        resp.getWriter().println(currentUser.getEmail());
//        resp.getWriter().println(currentUser.getFirstName());
//        resp.getWriter().println(currentUser.getLastName());

      req.getRequestDispatcher("index.html").forward(req,resp);


    }
}
