package com.revature.models;

public class ClientMessage {

    private String message;

    public ClientMessage() {
    }

    public ClientMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
