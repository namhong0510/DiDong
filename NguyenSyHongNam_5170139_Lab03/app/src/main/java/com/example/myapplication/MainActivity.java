package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int TOTAL_STUDENTS = 20;
    private ListView listView;
    private List<String> name = new ArrayList<>();
//    private String[] name = {"TDT Student 1", "TDT Student 2"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        /*ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, name);
        listView.setAdapter(arrayAdapter);*/

        addOnItemClickListener();
        setListAdapter();
        getRamdomStudents();

    }

    private void addOnItemClickListener(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String content = name.get(i);
                Toast.makeText(MainActivity.this, content, Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void setListAdapter(){
        ArrayAdapter<String> nameArrayAdapter = new ArrayAdapter<>(this, R.layout.itemlist, name);
        listView.setAdapter(nameArrayAdapter);
    }

    private  void getRamdomStudents(){
        for(int i =0; i<TOTAL_STUDENTS; i++){
            name.add("TDT Student" + i);
        }
    }
}