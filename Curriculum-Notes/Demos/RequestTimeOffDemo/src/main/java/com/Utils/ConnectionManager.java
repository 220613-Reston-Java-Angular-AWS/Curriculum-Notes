package com.Utils;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
    public static ConnectionManager connectionManager;
    public static Connection connection;


    private ConnectionManager(){

    }

    private ConnectionManager getConnectionManager(){
        if(connectionManager ==  null){
            connectionManager = new ConnectionManager();
        }

        return connectionManager;
    }

    public static Connection getConnection(){
        if (connection == null){
            connection = connect();
        }

        return connection;
    }

    private static Connection connect(){

        try {

            Properties props = new Properties();
            FileReader fileReader = new FileReader("src/main/resources/jdbc.properties");


            props.load(fileReader);

            StringBuilder sb = new StringBuilder();

            sb.append("jdbc:postgresql://");
            sb.append(props.get("hostname"));
            sb.append(":");
            sb.append(props.get("port"));
            sb.append("/");
            sb.append(props.get("database"));

            String connectionURL = sb.toString();
            String user = String.valueOf(props.getProperty("user"));
            String password = String.valueOf(props.getProperty("password"));
            System.out.println(connectionURL);
            connection = DriverManager.getConnection(connectionURL,user,password);

            System.out.println(connection.getClientInfo().toString() + " - this is to confirm the connection");

        }catch(IOException | SQLException e){
            System.out.println("Error in the ConnectionManager class:  " + e.getMessage());
        }

        return connection;
    }

}
