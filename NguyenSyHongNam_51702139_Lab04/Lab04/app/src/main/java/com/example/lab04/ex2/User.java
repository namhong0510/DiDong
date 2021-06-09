package com.example.lab04.ex2;

public class User {
    private String name;
    private String gmail;

    public User(String name, String gmail) {
        this.name = name;
        this.gmail = gmail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }
}
