package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class EmployeeAdapter extends ArrayAdapter implements Filterable {


    private LayoutInflater layoutInflater;
    private int layoutResource;
    private ArrayList<Employee> mOriginalValues; // Original Values
    private ArrayList<Employee> mDisplayedValues = new ArrayList<Employee>();    // Values to be displayed


    public EmployeeAdapter(@NonNull Context context, int resource, ArrayList<Employee> list) {
        super(context, resource, list);


        this.layoutInflater = LayoutInflater.from(context);
        this.layoutResource = resource;
        this.mDisplayedValues = list;

        this.mOriginalValues = new ArrayList<Employee>();
        this.mOriginalValues.addAll(mDisplayedValues);

    }


    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null)
            v = layoutInflater.inflate(layoutResource, parent, false);
        TextView nameVal = v.findViewById(R.id.nameValue);
        TextView idVal = v.findViewById(R.id.idValue);

        nameVal.setText(mDisplayedValues.get(position).getName());
        idVal.setText(Integer.toString(mDisplayedValues.get(position).getEmpID()));

        return v;


    }

    public Filter getFilter() {
        Filter filter = new Filter() {

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                mDisplayedValues = (ArrayList<Employee>) results.values; // has the filtered values
                notifyDataSetChanged();
                clear();
                for (int i = 0; i < mDisplayedValues.size(); i++) {
                    add(mDisplayedValues.get(i));
                    notifyDataSetInvalidated();
                }

                // notifies the data with new filtered values
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();        // Holds the results of a filtering operation in values
                ArrayList<Employee> FilteredArrList = new ArrayList<Employee>();

                if (mOriginalValues == null) {
                    mOriginalValues = new ArrayList<Employee>(mDisplayedValues); // saves the original data in mOriginalValues
                }


                if (constraint == null || constraint.length() == 0) {


                    results.count = mOriginalValues.size();
                    results.values = mOriginalValues;
                } else {
                    constraint = constraint.toString().toLowerCase();
                    for (int i = 0; i < mOriginalValues.size(); i++) {

                        String data = mOriginalValues.get(i).getName();
                        if (data.toLowerCase().startsWith(constraint.toString())) {

                            if (mOriginalValues.get(i).getEmpType().equalsIgnoreCase("Manager")) {
                                Manager mm = (Manager) mOriginalValues.get(i);
                                FilteredArrList.add(mm);

                            } else if (mOriginalValues.get(i).getEmpType().equalsIgnoreCase("Tester")) {
                                Tester mm = (Tester) mOriginalValues.get(i);
                                FilteredArrList.add(mm);

                            } else {

                                Programmer mm = (Programmer) mOriginalValues.get(i);
                                FilteredArrList.add(mm);


                            }


                        }
                    }
                    // set the Filtered result to return
                    results.count = FilteredArrList.size();

                    results.values = FilteredArrList;
                }
                return results;
            }
        };
        return filter;
    }
}





