package com.acg.entity;

public class PostDisscuss {
    private int d_id;
    private int p_id;
    private int u_id;
    private String d_content;
    private String d_createDate;
    private int d_to_d_id;
    private int d_number;
    private User user;

    public PostDisscuss() {
    }

    public PostDisscuss(int d_id, int p_id, int u_id, String d_content, String d_createDate, int d_to_d_id, int d_number, User user) {
        this.d_id = d_id;
        this.p_id = p_id;
        this.u_id = u_id;
        this.d_content = d_content;
        this.d_createDate = d_createDate;
        this.d_to_d_id = d_to_d_id;
        this.d_number = d_number;
        this.user = user;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
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

    public int getD_number() {
        return d_number;
    }

    public void setD_number(int d_number) {
        this.d_number = d_number;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
