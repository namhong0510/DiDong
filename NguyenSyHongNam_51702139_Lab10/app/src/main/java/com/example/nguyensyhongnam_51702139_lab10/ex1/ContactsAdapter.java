package com.example.nguyensyhongnam_51702139_lab10.ex1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.nguyensyhongnam_51702139_lab10.R;

import java.util.List;


public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.MyViewHolder> {

    private Context context;
    private List<Contact> contactsList;

    public ContactsAdapter(Context context, List<Contact> contactsList) {
        this.contactsList = contactsList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ex1_contact_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Contact contact = contactsList.get(position);
        holder.name.setText(contact.getName());
        holder.phoneNumber.setText(contact.getPhoneNumber());
        holder.status.setText("Active");
    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView phoneNumber;
        public TextView status;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            phoneNumber = view.findViewById(R.id.phoneNumber);
            status = view.findViewById(R.id.status);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent newActivity = new Intent(context, ContactDetailActivity.class);
                    newActivity.putExtra("vName", contactsList.get(getAdapterPosition()).getName());
                    newActivity.putExtra("vPhoneNumber", contactsList.get(getAdapterPosition()).getPhoneNumber());
                    context.startActivity(newActivity);
                }
            });
        }
    }
}
