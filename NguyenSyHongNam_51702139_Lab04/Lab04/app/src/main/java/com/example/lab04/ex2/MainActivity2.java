package com.example.lab04.ex2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lab04.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private TextView tvTotal;
    private Button btnAddUser, btnRemoveUser;
    private RecyclerView recyclerView;
    private List<User> users;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = findViewById(R.id.rv_2);
        tvTotal = findViewById(R.id.tv_total);
        btnAddUser = findViewById(R.id.btn_add_user);
        btnRemoveUser = findViewById(R.id.btn_remove_user);
        users = new ArrayList<>();
        userAdapter = new UserAdapter(this, users);


        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, RecyclerView.VERTICAL));
        recyclerView.setAdapter(userAdapter);

        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFiveMore();
            }
        });

        btnRemoveUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeLastFive();
            }
        });
    }

    private void addFiveMore(){
        int count = users.size();
        for(int i = 1; i<=5; i++){
            int id = count + i;
            users.add(new User("User " + id, "user" + id + "@gmail.com"));
        }
        userAdapter.notifyItemRangeInserted(count, 5);
    }

    private void removeLastFive(){
        int prevSize = users.size();
        int count =0;
        while (count < 5 && users.size() > 0){
            count++;
            users.remove(users.size() - 1);
        }
        userAdapter.notifyItemRangeRemoved(prevSize - 5 - 1, 5);
    }
}