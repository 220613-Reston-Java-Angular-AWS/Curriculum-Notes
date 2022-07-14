package com.Persistance;

public class Principal {

    Integer principalID;
    String firstName;
    String lastName;
    String email;
    String pass_word;

    public Principal() {
    }

    public Principal(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.pass_word = password;
    }

    public Principal(Integer principalID, String firstName, String lastName, String email, String password) {
        this.principalID = principalID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.pass_word = password;
    }

    public Integer getPrincipalID() {
        return principalID;
    }

    public void setPrincipalID(Integer principalID) {
        this.principalID = principalID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass_word() {
        return pass_word;
    }

    public void setPass_word(String password) {
        this.pass_word = password;
    }
}
