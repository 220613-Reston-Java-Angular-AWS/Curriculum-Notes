package com.servlets;

import com.Persistance.Request;
import com.Persistance.RequestDAO;
import com.Utils.CurrentUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class RequestServlet extends HttpServlet {

    RequestDAO requestDAO = new RequestDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);

        //here we are doing an if else statement


        ArrayList<Request> requests = requestDAO.getAllCurrentUserTimeOffRequests(CurrentUser.getUser());

        for(Request request: requests){
            resp.getWriter().println(request.toString());
        }


    }
}
