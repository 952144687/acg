package com.acg.entity;

public class  Post {
    private int p_id;
    private int u_id;
    private String p_time;
    private String tittle;
    private String content;
    private String type;
    private int collection;
    private boolean is_show;
    private User user;

    public Post() {
    }

    public Post(int p_id, int u_id, String p_time, String tittle, String content, String type, int collection, boolean is_show, User user) {
        this.p_id = p_id;
        this.u_id = u_id;
        this.p_time = p_time;
        this.tittle = tittle;
        this.content = content;
        this.type = type;
        this.collection = collection;
        this.is_show = is_show;
        this.user = user;
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

    public String getP_time() {
        return p_time;
    }

    public void setP_time(String p_time) {
        this.p_time = p_time;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCollection() {
        return collection;
    }

    public void setCollection(int collection) {
        this.collection = collection;
    }

    public boolean isIs_show() {
        return is_show;
    }

    public void setIs_show(boolean is_show) {
        this.is_show = is_show;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
