package com.example.lab05;

public class Data {
    int id;
    String appName, size, date;

    public Data(int id, String appName, String size, String date) {
        this.id = id;
        this.appName = appName;
        this.size = size;
        this.date = date;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
