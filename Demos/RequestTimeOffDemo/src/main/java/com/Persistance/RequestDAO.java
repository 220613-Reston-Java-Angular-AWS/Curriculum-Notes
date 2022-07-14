package com.Persistance;

import com.Utils.ConnectionManager;
import com.Utils.CurrentUser;
import com.Utils.CustomCRUDInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class RequestDAO implements CustomCRUDInterface<Request> {

    Connection connection;

    public RequestDAO(){
        connection = ConnectionManager.getConnection();
    }
    @Override
    public Integer create(Request request) {

        try {

            String sql = "INSERT INTO requests (requestID,startDate,endDate,description,approved," +
                    "teacherID,principalID) VALUES (default,?,?,?,?,?,?)";

            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setDate(1,request.getStartDate());
            pstmt.setDate(2,request.getEndDate());
            pstmt.setString(3,request.getDescription());
            pstmt.setBoolean(4, request.getApproved());
            pstmt.setInt(5,request.getTeacherID());
            pstmt.setInt(6,request.getPrincipalID());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();

            rs.next();

            return rs.getInt("requestID");

        }catch(Exception e){
            System.out.println("Error in Request DAO : " + e.getMessage());
        }




        return null;
    }

    @Override
    public Request read(Integer id) {
        return null;
    }

    @Override
    public Request update(Request request) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    public ArrayList<Request> getAllCurrentUserTimeOffRequests(CurrentUser teacher){
        ArrayList<Request> requests = new ArrayList<>();
        try {
            String sql;

            if (teacher.getSuperiorsID() == null) {
                sql = "SELECT * FROM requests WHERE principalID = ?";
                  } else {
                sql = "SELECT * FROM requests WHERE teacherID = ?";
            }

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, teacher.getUserId());

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                Request request = new Request(rs.getInt(1),
                        rs.getDate(2),rs.getDate(3),rs.getString(4),
                        rs.getBoolean(5),rs.getInt(6),rs.getInt(7));

                requests.add(request);
            }
            return requests;
        } catch(Exception e){
            System.out.println("This is the Requests Dao - " + e.getMessage() );
        }
        return null;
    }



}
