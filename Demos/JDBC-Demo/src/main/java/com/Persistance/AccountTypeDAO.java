package com.Persistance;

import com.Utils.ConnectionManager;
import com.Utils.CustomDAOInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AccountTypeDAO implements CustomDAOInterface<AccountType> {

    Connection connection;

    public AccountTypeDAO(){
        connection = ConnectionManager.getConnection();
    }

    @Override
    public Integer create(AccountType accountType) {

        try {
            String sql = "INSERT INTO accounttype (acc_ty_id, type_name) VALUES (default,?)";
            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1,accountType.getType_name());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();

            rs.next();

            return  rs.getInt(1);


        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public AccountType read(Integer id) {
        return null;
    }

    @Override
    public AccountType update(AccountType accountType) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
