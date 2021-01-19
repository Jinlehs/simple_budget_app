package com.example.jl6_trialbook;

public class Entry {
    private String name;
    private String date;
    private String cost;

    public Entry(String name, String date, String cost) {
        this.name = name;
        this.date = date;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
