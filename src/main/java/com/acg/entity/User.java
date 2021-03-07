package com.acg.entity;

public class User {
    private int u_id;
    private String u_mail;
    private String u_password;
    private String u_name;
    private String u_img;
    private String u_introduction;
    private boolean u_is_show;

    public User() {
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getU_mail() {
        return u_mail;
    }

    public void setU_mail(String u_mail) {
        this.u_mail = u_mail;
    }

    public String getU_password() {
        return u_password;
    }

    public void setU_password(String u_password) {
        this.u_password = u_password;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_img() {
        return u_img;
    }

    public void setU_img(String u_img) {
        this.u_img = u_img;
    }

    public String getU_introduction() {
        return u_introduction;
    }

    public void setU_introduction(String u_introduction) {
        this.u_introduction = u_introduction;
    }

    public boolean isU_is_show() {
        return u_is_show;
    }

    public void setU_is_show(boolean u_is_show) {
        this.u_is_show = u_is_show;
    }

    public User(int u_id, String u_mail, String u_password, String u_name, String u_img, String u_introduction, boolean u_is_show) {
        this.u_id = u_id;
        this.u_mail = u_mail;
        this.u_password = u_password;
        this.u_name = u_name;
        this.u_img = u_img;
        this.u_introduction = u_introduction;
        this.u_is_show = u_is_show;
    }
}
