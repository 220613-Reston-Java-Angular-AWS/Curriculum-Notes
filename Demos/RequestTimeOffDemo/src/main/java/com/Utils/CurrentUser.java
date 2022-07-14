package com.Utils;

public class CurrentUser {
    public static CurrentUser user;
    public static Integer userId;
    public static String firstName;
    public static String lastName;
    public static String email;
    public static String password;
    public static Integer superiorsID;


    public CurrentUser() {
    }

    public CurrentUser(Integer userId, String firstName, String lastName, String email, String password, Integer superiorsID) {
        CurrentUser.userId = userId;
        CurrentUser.firstName = firstName;
        CurrentUser.lastName = lastName;
        CurrentUser.email = email;
        CurrentUser.password = password;
        CurrentUser.superiorsID = superiorsID;
    }

    public CurrentUser(Integer userId, String firstName, String lastName, String email, String password) {
        CurrentUser.userId = userId;
        CurrentUser.firstName = firstName;
        CurrentUser.lastName = lastName;
        CurrentUser.email = email;
        CurrentUser.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        CurrentUser.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        CurrentUser.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        CurrentUser.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        CurrentUser.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        CurrentUser.password = password;
    }

    public Integer getSuperiorsID() {
        return superiorsID;
    }

    public void setSuperiorsID(Integer superiorsID) {
        CurrentUser.superiorsID = superiorsID;
    }

    public static CurrentUser getUser() {
        return user;
    }

    public static void setUser(CurrentUser user) {
        CurrentUser.user = user;
    }
}
