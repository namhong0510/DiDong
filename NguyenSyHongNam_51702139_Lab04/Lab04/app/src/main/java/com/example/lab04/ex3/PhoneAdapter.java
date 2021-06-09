package com.example.lab04.ex3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lab04.R;

import java.util.List;

public class PhoneAdapter extends ArrayAdapter<Phone> {

    private Context context;
    private int layout;
    private List<Phone> data;

    public PhoneAdapter(Context context, int resource, List<Phone> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layout = resource;
        this.data = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(layout, parent, false);
        ImageView icon = view.findViewById(R.id.img_icon);
        TextView tvTitle = view.findViewById(R.id.tv_name_phone);
        CheckBox enable = view.findViewById(R.id.cb_enable);
        Phone phone = data.get(position);
        tvTitle.setText(phone.getName());
        icon.setImageResource(phone.getIcon());
        enable.setChecked(phone.isChecked());
        return view;
    }
}
