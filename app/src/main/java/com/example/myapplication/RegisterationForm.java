package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class RegisterationForm extends AppCompatActivity {

    Spinner emptype;
    TextView clientsTV, bugsTV, projectsTV;
    EditText clientsET, bugsET, projectsET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration_form);
        emptype = findViewById(R.id.spinner);
        clientsTV = findViewById(R.id.clientst);
        clientsET = findViewById(R.id.clientse);
        bugsTV = findViewById(R.id.bugst);
        bugsET = findViewById(R.id.bugse);
        projectsET = findViewById(R.id.projectse);
        projectsTV = findViewById(R.id.projectst);


        emptype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String etype = emptype.getItemAtPosition(position).toString();
                if (etype.equalsIgnoreCase("Manager")) {
                    clientsET.setVisibility(View.VISIBLE);
                    clientsTV.setVisibility(View.VISIBLE);
                    bugsET.setVisibility(View.GONE);
                    bugsTV.setVisibility(View.GONE);
                    projectsET.setVisibility(View.GONE);
                    projectsTV.setVisibility(View.GONE);


                } else if (etype.equalsIgnoreCase("Tester")) {

                    bugsET.setVisibility(View.VISIBLE);
                    bugsTV.setVisibility(View.VISIBLE);
                    clientsET.setVisibility(View.GONE);
                    clientsTV.setVisibility(View.GONE);
                    projectsET.setVisibility(View.GONE);
                    projectsTV.setVisibility(View.GONE);


                } else if (etype.equalsIgnoreCase("Programmer")) {
                    projectsET.setVisibility(View.VISIBLE);
                    projectsTV.setVisibility(View.VISIBLE);
                    bugsET.setVisibility(View.GONE);
                    bugsTV.setVisibility(View.GONE);
                    clientsET.setVisibility(View.GONE);
                    clientsTV.setVisibility(View.GONE);

                } else {
                    bugsET.setVisibility(View.GONE);
                    bugsTV.setVisibility(View.GONE);
                    clientsET.setVisibility(View.GONE);
                    clientsTV.setVisibility(View.GONE);
                    projectsET.setVisibility(View.GONE);
                    projectsTV.setVisibility(View.GONE);

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


}
