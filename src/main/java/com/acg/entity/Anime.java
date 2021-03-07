package com.acg.entity;

public class Anime {
    private int a_id;
    private String a_name;
    private String a_image;
    private String a_time;
    private String a_type;
    private String a_introduction;
    private  int a_size;
    private boolean a_is_show;
    private Double a_score;
    private int a_collection;
    private String a_handle;
    private boolean a_change;


    public Anime() {
    }

    public Anime(int a_id, String a_name, String a_image, String a_time, String a_type, String a_introduction, int a_size, boolean a_is_show, Double a_score, int a_collection, String a_handle, boolean a_change) {
        this.a_id = a_id;
        this.a_name = a_name;
        this.a_image = a_image;
        this.a_time = a_time;
        this.a_type = a_type;
        this.a_introduction = a_introduction;
        this.a_size = a_size;
        this.a_is_show = a_is_show;
        this.a_score = a_score;
        this.a_collection = a_collection;
        this.a_handle = a_handle;
        this.a_change = a_change;
    }

    public int getA_size() {
        return a_size;
    }

    public void setA_size(int a_size) {
        this.a_size = a_size;
    }

    public String getA_handle() {
        return a_handle;
    }

    public void setA_handle(String a_handle) {
        this.a_handle = a_handle;
    }

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public String getA_name() {
        return a_name;
    }

    public void setA_name(String a_name) {
        this.a_name = a_name;
    }

    public String getA_image() {
        return a_image;
    }

    public void setA_image(String a_image) {
        this.a_image = a_image;
    }

    public String getA_time() {
        return a_time;
    }

    public void setA_time(String a_time) {
        this.a_time = a_time;
    }

    public String getA_type() {
        return a_type;
    }

    public void setA_type(String a_type) {
        this.a_type = a_type;
    }

    public String getA_introduction() {
        return a_introduction;
    }

    public void setA_introduction(String a_introduction) {
        this.a_introduction = a_introduction;
    }

    public boolean isA_is_show() {
        return a_is_show;
    }

    public void setA_is_show(boolean a_is_show) {
        this.a_is_show = a_is_show;
    }

    public Double getA_score() {
        return a_score;
    }

    public void setA_score(Double a_score) {
        this.a_score = a_score;
    }

    public int getA_collection() {
        return a_collection;
    }

    public void setA_collection(int a_collection) {
        this.a_collection = a_collection;
    }

    public boolean isA_change() {
        return a_change;
    }

    public void setA_change(boolean a_change) {
        this.a_change = a_change;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "a_id=" + a_id +
                ", a_name='" + a_name + '\'' +
                ", a_image='" + a_image + '\'' +
                ", a_time='" + a_time + '\'' +
                ", a_type='" + a_type + '\'' +
                ", a_introduction='" + a_introduction + '\'' +
                ", a_size=" + a_size +
                ", a_is_show=" + a_is_show +
                ", a_score=" + a_score +
                ", a_collection=" + a_collection +
                ", a_handle='" + a_handle + '\'' +
                ", a_change=" + a_change +
                '}';
    }
}
