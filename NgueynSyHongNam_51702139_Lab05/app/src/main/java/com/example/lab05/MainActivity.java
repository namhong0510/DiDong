package com.example.lab05;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Data> datas;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateRecyclerView();
    }

    public void generateRecyclerView(){
        recyclerView=findViewById(R.id.recyclerView);
        adapter = new MyAdapter(this, initData());
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    public ArrayList initData(){
        datas = new ArrayList<>();
        for(int i=1; i < 4; i++){
            datas.add(new Data(i ,"App" + i, "32 MB", "10/05/2020"));
        }

        return datas;
    }
}