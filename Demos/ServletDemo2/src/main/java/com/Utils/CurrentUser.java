package com.Utils;

public class CurrentUser {
    public static CurrentUser currentUser;
    public static Integer user_Id;
    public static String first_name;
    public static String last_name;
    public static String email;

    public CurrentUser(Integer user_Id, String first_name,String last_name, String email){
    CurrentUser.user_Id = user_Id;
    CurrentUser.first_name = first_name;
    CurrentUser.last_name = last_name;
    CurrentUser.email = email;
    }
}