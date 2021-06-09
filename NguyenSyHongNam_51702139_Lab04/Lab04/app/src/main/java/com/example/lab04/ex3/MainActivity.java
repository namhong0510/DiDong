package com.example.lab04.ex3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.lab04.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private List<Phone> phoneList;
    private PhoneAdapter phoneAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
        initData();
    }

    private void initData() {
        phoneList = new ArrayList<>();
        phoneList.add(new Phone(R.drawable.mobile3, "Apple"));
        phoneList.add(new Phone(R.drawable.mobile2, "Oppo"));
        phoneList.add(new Phone(R.drawable.mobile3, "Samsung"));
        phoneList.add(new Phone(R.drawable.mobile, "Nokia"));
        phoneList.add(new Phone(R.drawable.red_monitor, "LG"));
        phoneList.add(new Phone(R.drawable.blue_monitor, "Microsoft"));
        phoneList.add(new Phone(R.drawable.mobile2, "Xiaomi"));

        phoneAdapter = new PhoneAdapter(this, R.layout.ex3_custom_row, phoneList);
        lv.setAdapter(phoneAdapter);
    }

    private void initView() {
        lv = findViewById(R.id.listView);
    }
}