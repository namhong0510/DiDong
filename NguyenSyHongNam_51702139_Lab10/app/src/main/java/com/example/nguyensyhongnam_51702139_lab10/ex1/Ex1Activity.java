package com.example.nguyensyhongnam_51702139_lab10.ex1;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nguyensyhongnam_51702139_lab10.R;
import com.example.nguyensyhongnam_51702139_lab10.ex1.Contact;
import com.example.nguyensyhongnam_51702139_lab10.ex1.ContactsAdapter;

import java.util.ArrayList;
import java.util.List;


public class Ex1Activity extends AppCompatActivity {
    private List<Contact> contactsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ContactsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex1_activity);

        recyclerView = findViewById(R.id.recycler_view);

        mAdapter = new ContactsAdapter(getBaseContext(), contactsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // set the adapter
        recyclerView.setAdapter(mAdapter);

        prepareContactData();
    }

    private void prepareContactData() {
        Contact contact = new Contact("Nguyen Sy Hong Nam", "0367 026 199");
        contactsList.add(contact);

        Contact contact2 = new Contact("Nguyen Van A", "0906 246 489");
        contactsList.add(contact2);

        Contact contact3 = new Contact("Nguyen Van B", "0906 246 489");
        contactsList.add(contact3);

        mAdapter.notifyDataSetChanged();
    }
}