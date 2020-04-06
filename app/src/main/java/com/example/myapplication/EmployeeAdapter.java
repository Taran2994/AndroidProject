package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class EmployeeAdapter extends ArrayAdapter {

    private ArrayList<Employee> list;
    private final LayoutInflater layoutInflater;
    private final int layoutResource;


    public EmployeeAdapter(@NonNull Context context, int resource, ArrayList<Employee> list) {
        super(context, resource,list);
        this.list = list;
        this.layoutInflater = LayoutInflater.from(context);
        this.layoutResource = resource;

    }


    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null)
            v = layoutInflater.inflate(layoutResource, parent, false);
        TextView nameVal = v.findViewById(R.id.nameValue);
        TextView idVal = v.findViewById(R.id.idValue);

        nameVal.setText(list.get(position).getName());
        idVal.setText(list.get(position).getEmpID());
        return v;


    }
}
