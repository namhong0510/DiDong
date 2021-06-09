package com.example.myapplication;

public class Student {
    private String name;
    private Boolean checked;

    public Student(String name){
        this.name = name;
        this.checked = false;
    }

    public Student(String name, boolean checked){
        this.name = name;
        this.checked = checked;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public boolean isChecked(){
        return checked;
    }

    public void setChecked(boolean checked){
        this.checked = checked;
    }
}
