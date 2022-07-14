package com.Persistance;

import com.Utils.ConnectionManager;
import com.Utils.CurrentUser;
import com.Utils.CustomCRUDInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TeacherDAO implements CustomCRUDInterface<Teacher> {

    Connection connection;

    public TeacherDAO(){
        connection = ConnectionManager.getConnection();
    }

    @Override
    public Integer create(Teacher teacher) {
        try {

            String sql = "INSERT INTO teachers (teacherID,firstName,lastName,email,pass_word,principalID)" +
                    "VALUES (default,?,?,?,?,?)";

            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1,teacher.getFirstName());
            pstmt.setString(2, teacher.getLastName());
            pstmt.setString(3,teacher.getEmail());
            pstmt.setString(4, teacher.getPass_word());
            pstmt.setInt(5,teacher.getPrincipalID());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();

            rs.next();

                    return rs.getInt("teacherID");

        }catch(Exception e){
            System.out.println("Error in Teacher DAO : " + e.getMessage());
        }




        return null;
    }

    @Override
    public Teacher read(Integer id) {

        try {
            String sql = "SELECT * FROM teachers WHERE teacherId = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1,id);

          ResultSet rs = pstmt.executeQuery();

          Teacher teacher = new Teacher();
          while (rs.next()){
              teacher.setTeacherID(rs.getInt("teacherID"));
              teacher.setFirstName(rs.getString("firstName"));
              teacher.setLastName(rs.getString("lastName"));
              teacher.setEmail(rs.getString("email"));
              teacher.setPass_word(rs.getString("pass_word"));
              teacher.setPrincipalID(rs.getInt("principalID"));
          }
                return teacher;
        } catch(Exception e){
            System.out.println("Error in Teacher DAO: " + e.getMessage());
        }





        return null;
    }

    @Override
    public Teacher update(Teacher teacher) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    public CurrentUser loginCurrentTeacher(String email, String password){

        try {

            String sql = "SELECT * FROM teachers WHERE email = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,email);

            ResultSet rs = pstmt.executeQuery();

            if(rs.next() && rs.getString("pass_word").equals(password)){
              return new CurrentUser(rs.getInt(1),
                        rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5),rs.getInt(6));
            }



        } catch(Exception e){
            System.out.println("This is the TeacherDAO - " + e.getMessage());
        }



        return null;
    }
}
