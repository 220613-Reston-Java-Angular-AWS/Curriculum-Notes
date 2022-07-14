package com.Utils;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionManager {

    public static ConnectionManager connectionManager;
    public static Connection connection;


    private ConnectionManager(){
    }

    private ConnectionManager getConnectionManager(){
        if(connectionManager == null){
            connectionManager = new ConnectionManager();
        }
        return connectionManager;
    }

    public static Connection getConnection(){
        if(connection == null){
            connection = connect();
        }
        return connection;
    }

    public static Connection connect(){

        try {
            Properties props = new Properties();
            FileReader fileReader = new FileReader("/Users/tiffanyobi/Documents/Java-Angular-AWS-2022" +
                    "/Curriculum-Notes/Demos/ServletDemo/src/main/resources/jdbc.properties");

            props.load(fileReader);

            String connectionURL;

            //here we are building our String using StringBuilder

            StringBuilder sb = new StringBuilder();
            sb.append("jdbc:postgresql://");
            sb.append(props.get("hostname"));
            sb.append(":");
            sb.append(props.get("port"));
            sb.append("/");
            sb.append(props.get("dbname"));


            connectionURL = sb.toString();

            String user = String.valueOf(props.get("username"));
            String password = String.valueOf(props.getProperty("password"));

            System.out.println(connectionURL);

            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(connectionURL,user,password);

            System.out.println(connection.getClientInfo().toString() +
                    "This is to confirm the connetion was made");

//this is our catch block to catch any error that might happen
            //the errors that are specifically thrown when we create this Connection Manager
            //is IOException - FileReader
            //is SQLException - DriverManager.getConnection()
        }catch(Exception e){
            System.out.println("Error in the Connection: " + e.getMessage());
        }

        return connection;
    }

//    public static void main(String[] args) {
//        ConnectionManager.getConnection();
//    }

}
