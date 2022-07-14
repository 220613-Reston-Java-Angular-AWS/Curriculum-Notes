package com.Persistance;

public class Teacher {

    Integer teacherID;
    String firstName;
    String lastName;
    String email;
    String pass_word;
    Integer principalID;

    public Teacher() {
    }

    public Teacher(String firstName, String lastName, String email, String password,Integer principalID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.pass_word = password;
        this.principalID = principalID;
    }

    public Teacher(Integer teacherID, String firstName, String lastName, String email, String password,
                   Integer principalID) {
        this.teacherID = teacherID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.pass_word = password;
        this.principalID = principalID;
    }

    public Integer getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(Integer teacherID) {
        this.teacherID = teacherID;
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

    public void setPass_word(String pass_word) {
        this.pass_word = pass_word;
    }

    public Integer getPrincipalID() {
        return principalID;
    }

    public void setPrincipalID(Integer principalID) {
        this.principalID = principalID;
    }
}
