package com.Persistance;

import com.Utils.ConnectionManager;
import com.Utils.CustomDAOInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AccountDAO implements CustomDAOInterface<Account> {

    Connection connection;

    public AccountDAO(){
        connection = ConnectionManager.getConnection();
    }


    @Override
    public Integer create(Account account) {

        try {

            String sql = "INSERT INTO accounts (acc_id,balance,type_id,user_id,opened) VALUES (default,?,?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setDouble(1,account.getBalance());
            pstmt.setInt(2,account.getType_id());
            pstmt.setInt(3,account.getUser_id());
            pstmt.setDate(4,account.getOpened());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();

            rs.next();
            return rs.getInt(1);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public Account read(Integer id) {
        return null;
    }

    @Override
    public Account update(Account account) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
