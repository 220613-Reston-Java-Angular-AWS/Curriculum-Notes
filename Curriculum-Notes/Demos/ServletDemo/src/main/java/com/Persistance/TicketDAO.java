package com.Persistance;

import com.Utils.ConnectionManager;
import com.Utils.CustomCRUDInterface;
import com.models.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TicketDAO implements CustomCRUDInterface<Ticket> {
    Connection conn;

    public TicketDAO(){
        conn = ConnectionManager.getConnection();
    }





    @Override
    public Integer create(Ticket ticket) {

        try {
            String sql = "INSERT INTO tickets (ticket_id,description,user_id) VALUES (default,?,?)";

            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, ticket.getDescription());
            pstmt.setInt(2,ticket.getUserID());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();

            rs.next();

            return rs.getInt(1);



        } catch(Exception e){
            System.out.println("this is the TicketDao: "+ e.getMessage() );

        }


        return null;
    }

    @Override
    public Ticket read(Integer id) {


        return null;
    }

    @Override
    public Ticket update(Ticket ticket) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }


    public ArrayList<Ticket> getAllTicketsForUser(Integer id){

        ArrayList<Ticket> tickets = new ArrayList<>();

        try {

                String sql = "SELECT * FROM tickets WHERE user_id = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1,id);

                ResultSet rs = pstmt.executeQuery();


                while (rs.next()){

                    Ticket ticket = new Ticket(rs.getInt(1),rs.getString(2),
                            rs.getInt(3));
                    tickets.add(ticket);
                }


        }catch(Exception e){
            System.out.println("This is the TicketDAO: " + e.getMessage());
        }





        return tickets;
    }
}
