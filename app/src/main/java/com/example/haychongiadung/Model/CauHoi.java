package com.example.haychongiadung.Model;

public class CauHoi {
    private int id;
    private String cauhoi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCauhoi() {
        return cauhoi;
    }

    public void setCauhoi(String cauhoi) {
        this.cauhoi = cauhoi;
    }

    public CauHoi(int id, String cauhoi) {
        this.id = id;
        this.cauhoi = cauhoi;
    }

    public CauHoi() {
    }
}
