package com.acg.entity;

public class Disscuss {
    private int d_id;
    private int a_id;
    private int u_id;
    private String d_content;
    private String d_createDate;
    private int d_to_d_id;
    private int d_number;
    private User user;

    public Disscuss() {
    }

    public Disscuss(int d_id, int a_id, int u_id, String d_content, String d_createDate, int d_to_d_id, int d_number, User user) {
        this.d_id = d_id;
        this.a_id = a_id;
        this.u_id = u_id;
        this.d_content = d_content;
        this.d_createDate = d_createDate;
        this.d_to_d_id = d_to_d_id;
        this.d_number = d_number;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getD_number() {
        return d_number;
    }

    public void setD_number(int d_number) {
        this.d_number = d_number;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getD_content() {
        return d_content;
    }

    public void setD_content(String d_content) {
        this.d_content = d_content;
    }

    public String getD_createDate() {
        return d_createDate;
    }

    public void setD_createDate(String d_createDate) {
        this.d_createDate = d_createDate;
    }

    public int getD_to_d_id() {
        return d_to_d_id;
    }

    public void setD_to_d_id(int d_to_d_id) {
        this.d_to_d_id = d_to_d_id;
    }
}
