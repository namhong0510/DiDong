package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private GridView gridView;
    private List<Student> students = new ArrayList<>(100);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        gridView.findViewById(R.id.gv);

        getRamdomStudent();
    }

    private void getRamdomStudent(){
        for(int i=0; i<100; i++){
            String studentName = "Student" + i;
            Student newStudent = new Student(studentName, true);
            students.add(newStudent);
        }
    }
}