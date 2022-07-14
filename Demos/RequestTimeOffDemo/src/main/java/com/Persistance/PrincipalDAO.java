package com.Persistance;

import com.Utils.ConnectionManager;
import com.Utils.CurrentUser;
import com.Utils.CustomCRUDInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PrincipalDAO implements CustomCRUDInterface<Principal> {
Connection connection;

public PrincipalDAO(){
    connection = ConnectionManager.getConnection();
}
    @Override
    public Integer create(Principal principal) {
        try {

            String sql = "INSERT INTO principals (principalID,firstName,lastName,email,password)" +
                    "VALUES (default,?,?,?,?)";

            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1,principal.getFirstName());
            pstmt.setString(2, principal.getLastName());
            pstmt.setString(3,principal.getEmail());
            pstmt.setString(4, principal.getPass_word());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();

            rs.next();

            return rs.getInt("principalID");

        }catch(Exception e){
            System.out.println("Error in Principal DAO : " + e.getMessage());
        }

        return null;
    }

    @Override
    public Principal read(Integer id) {
        return null;
    }

    @Override
    public Principal update(Principal principal) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    public boolean approveTimeOffRequest(Integer id, Boolean decision){

    try {

        String sql = "SELECT * FROM requests WHERE requestID = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, id);

        ResultSet rs = pstmt.executeQuery();

        if(rs.next() && rs.getBoolean("approved")==false){
            sql = "UPDATE requests SET approved = ? WHERE requestID = ?";
           pstmt = connection.prepareStatement(sql);
           pstmt.setBoolean(1,decision);
           pstmt.setInt(2,rs.getInt("requestID"));
           return true;
        }


    } catch(Exception e){
        System.out.println("This is the Principal DAO - " + e.getMessage());
    }


    return false;
    }


    public CurrentUser loginCurrentPrincipal(String email, String password){

        try {

            String sql = "SELECT * FROM principals WHERE email = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,email);

            ResultSet rs = pstmt.executeQuery();

            if(rs.next() && rs.getString("pass_word").equals(password)){
                return new CurrentUser(rs.getInt(1),
                        rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5));
            }

        } catch(Exception e){
            System.out.println("This is the PrincipalDAO - " + e.getMessage());
        }

        return null;
    }
}
