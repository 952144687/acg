package com.acg.entity;

public class AnimeItem {
    private int a_id;
    private int a_number;
    private String a_address;
    private boolean a_change;
    private Anime anime;

    public Anime getAnime() {
        return anime;
    }

    public void setAnime(Anime anime) {
        this.anime = anime;
    }

    public AnimeItem() {
    }

    public AnimeItem(int a_id, int a_number, String a_address, boolean a_change) {
        this.a_id = a_id;
        this.a_number = a_number;
        this.a_address = a_address;
        this.a_change = a_change;
    }

    @Override
    public String toString() {
        return "AnimeItem{" +
                "a_id=" + a_id +
                ", a_number=" + a_number +
                ", a_address='" + a_address + '\'' +
                ", a_change=" + a_change +
                ", anime=" + anime +
                '}';
    }

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public int getA_number() {
        return a_number;
    }

    public void setA_number(int a_number) {
        this.a_number = a_number;
    }

    public String getA_address() {
        return a_address;
    }

    public void setA_address(String a_address) {
        this.a_address = a_address;
    }

    public boolean isA_change() {
        return a_change;
    }

    public void setA_change(boolean a_change) {
        this.a_change = a_change;
    }
}
