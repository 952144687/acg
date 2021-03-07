package com.acg.entity;

public class Picture {
    private int pic_id;
    private int pic_atlas_number;
    private int u_id;
    private int pic_number;
    private String pic_url;
    private boolean pic_is_show;
    private String pic_tittle;
    private String pic_time;
    private User user;

    public Picture() {
    }

    public Picture(int pic_id, int pic_atlas_number, int u_id, int pic_number, String pic_url, boolean pic_is_show, String pic_tittle, String pic_time, User user) {
        this.pic_id = pic_id;
        this.pic_atlas_number = pic_atlas_number;
        this.u_id = u_id;
        this.pic_number = pic_number;
        this.pic_url = pic_url;
        this.pic_is_show = pic_is_show;
        this.pic_tittle = pic_tittle;
        this.pic_time = pic_time;
        this.user = user;
    }

    public int getPic_id() {
        return pic_id;
    }

    public void setPic_id(int pic_id) {
        this.pic_id = pic_id;
    }

    public int getPic_atlas_number() {
        return pic_atlas_number;
    }

    public void setPic_atlas_number(int pic_atlas_number) {
        this.pic_atlas_number = pic_atlas_number;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public int getPic_number() {
        return pic_number;
    }

    public void setPic_number(int pic_number) {
        this.pic_number = pic_number;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public boolean isPic_is_show() {
        return pic_is_show;
    }

    public void setPic_is_show(boolean pic_is_show) {
        this.pic_is_show = pic_is_show;
    }

    public String getPic_tittle() {
        return pic_tittle;
    }

    public void setPic_tittle(String pic_tittle) {
        this.pic_tittle = pic_tittle;
    }

    public String getPic_time() {
        return pic_time;
    }

    public void setPic_time(String pic_time) {
        this.pic_time = pic_time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
