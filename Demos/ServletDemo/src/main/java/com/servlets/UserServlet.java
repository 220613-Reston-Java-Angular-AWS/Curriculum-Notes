package com.servlets;

import com.Persistance.TicketDAO;
import com.Persistance.UserDAO;
// import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.models.Ticket;
import com.models.User;
import com.sun.net.httpserver.Headers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

//@CrossOrigin(origins = "*", maxAge = 3600)
public class UserServlet extends HttpServlet {

    UserDAO userDAO = new UserDAO();
    TicketDAO ticketDAO = new TicketDAO();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String URI = req.getRequestURI().replace("/ServletDemo/","");

//        System.out.println(req.getRequestURI());

        //this logic allows us to go through our headers to see what headers we have

//        Map<String, String> map = new HashMap<String, String>();
//
//        Enumeration headerNames = req.getHeaderNames();
//        while (headerNames.hasMoreElements()) {
//            String key = (String) headerNames.nextElement();
//            String value = req.getHeader(key);
//            map.put(key, value);
//        }

//
//        System.out.println(map);
//        String id = req.getHeader("user-id");

//        System.out.println(id + " this is the userID from the req");

//        Integer id = Integer.parseInt(req.getHeader("user-id"));



        switch (URI){


            case "tickets":

                getAllTicketsForCurrentUser(req,resp);

            break;
            default:

                System.out.println("WE are in the user Servlet ");

                break;


        }



    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);

        String URI = req.getRequestURI().replace("/ServletDemo/", "");

        System.out.println(URI);

        switch (URI) {
            case "user":


                processLoginForUser(req, resp);

                break;

            case "tickets":

                createNewTicket(req,resp);

                break;

            default:
                System.out.println("we're in the default");
                break;
        }


    }


    private void processLoginForUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        BufferedReader br = req.getReader();

        StringBuilder sb = new StringBuilder();

        String line = br.readLine();

        // here we are reading through each line of the req.getReader
        //it can be one line or more than one line
        //creating a while loop is safer
        while (line != null) {
            sb.append(line);
            //just in case we have more than one line in our reader
            line = br.readLine();
        }

//        System.out.println(sb);
        String body = sb.toString();

        String[] sepByAmp = body.split(",");

        List<String> values = new ArrayList<String>();

        for (String pair : sepByAmp) { // each element in array looks like this
//            values.add(pair.substring(pair.indexOf("=") + 1)); // trim each String element in the array to just value -> [bob, pass]

            pair = pair.replaceAll("\\{", "").replaceAll("}", "").replaceAll("\"", "");
//            System.out.println(pair);

            String target = pair.substring(pair.indexOf(":") + 1);
//            System.out.println(target);
            values.add(target); // we are trimming our string

        }
//
//        for (String value : values) {
//            System.out.println(value);
//        }
        String username = values.get(0); // bob
        String password = values.get(1); // pass

        User user = userDAO.loginUser(username, password);


        if (user != null) {
            resp.setStatus(200);

            // grab the session & add the user to the session
            //it manages whos logged in and whose logged out
            //created a session between our client and server
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            //not that if you are 'logging a user out and you've set the session
            // use 'req.getSession().removeAttribute("user");' to remove them from the current session





            // print the logged in user to the screen (shows if there is no html present)
            PrintWriter out = resp.getWriter();
            resp.setContentType("application/json");

            ObjectMapper om = new ObjectMapper();
            // convert the object with the object mapper
            out.println(om.writeValueAsString(user));

            // log it!
//            System.out.println("The user " + username + " has logged in.");

        } else {
            resp.setStatus(204);
        }

    }



    private void getAllTicketsForCurrentUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        resp.setStatus(200);
        resp.setContentType("application/json");

        // get the user id we set in the header
        Integer id = Integer.parseInt(req.getHeader("user-id"));

//        System.out.println(id + " this is the user id ");


        // get he tickets from the db
       ArrayList<Ticket> tickets = ticketDAO.getAllTicketsForUser(id);
//
//       for(Ticket ticket: tickets){
//           System.out.println(ticket.getUserID());
//       }

       //create object mapper to make the array into json data
        ObjectMapper mapper = new ObjectMapper();
       String json = mapper.writeValueAsString(tickets);

//        System.out.println(json + " this is supposed to be json");

        PrintWriter out = resp.getWriter();
        out.println(json);


    }


    private void createNewTicket(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BufferedReader br = req.getReader();

        StringBuilder sb = new StringBuilder();

        String line = br.readLine();

        // here we are reading through each line of the req.getReader
        //it can be one line or more than one line
        //creating a while loop is safer
        while (line != null) {
            sb.append(line);
            //just in case we have more than one line in our reader
            line = br.readLine();
        }

        System.out.println(sb);

        Integer id = Integer.parseInt(req.getHeader("user-id"));

        System.out.println(id + " current user id");

        String description = sb.toString().replaceAll("\"","");

        Ticket newTicket = new Ticket(description,id);

        System.out.println(newTicket.getUserID() + newTicket.getDescription());

        Integer ticketID = ticketDAO.create(newTicket);


        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(ticketID);

        PrintWriter out = resp.getWriter();
        out.println(json);

        resp.setStatus(200);
        resp.setContentType("application/json");
    }
}
