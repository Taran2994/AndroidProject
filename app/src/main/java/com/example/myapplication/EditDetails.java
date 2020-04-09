package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class EditDetails extends AppCompatDialogFragment {

    int position;
    String empType, vehType;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_edit_details, null);
       // SingletonClass singl= SingletonClass.getInstance();

        Bundle bundle = getArguments();
        position = bundle.getInt("Position");
        empType=bundle.getString("EmpType");
        vehType=bundle.getString("VehType");
        builder.setView(view);
        builder.setTitle("Edit Details");

        builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              


            }
        });
        return builder.create();


    }
}
