package com.Persistance;

public class AccountType {
    private Integer acc_ty_id;
    private String type_name;

    public AccountType(){

    }

    public AccountType(Integer acc_ty_id, String type_name) {
        this.acc_ty_id = acc_ty_id;
        this.type_name = type_name;
    }

    public AccountType(String type_name) {
        this.type_name = type_name;
    }

    public Integer getAcc_ty_id() {
        return acc_ty_id;
    }

    public void setAcc_ty_id(Integer acc_ty_id) {
        this.acc_ty_id = acc_ty_id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }
}
