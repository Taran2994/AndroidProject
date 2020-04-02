package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class RegisterationForm extends AppCompatActivity {

    Spinner emptype;
    TextView clientsTV, bugsTV, projectsTV, carTypeTV, sideCarTV;
    EditText clientsET, bugsET, projectsET, carTypeET;
    RadioGroup vehType, sideCar;


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
        vehType = findViewById(R.id.radioGroup2);
        carTypeET = findViewById(R.id.editText);
        carTypeTV = findViewById(R.id.textView);
        sideCar = findViewById(R.id.radioGroup);
        sideCarTV = findViewById(R.id.Sidebare);
        sideCar.setVisibility(View.GONE);
        sideCarTV.setVisibility(View.GONE);


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

        vehType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                {
                    if (checkedId == R.id.radioButton) {
                        carTypeET.setVisibility(View.VISIBLE);
                        carTypeTV.setVisibility(View.VISIBLE);
                        sideCar.setVisibility(View.GONE);
                        sideCarTV.setVisibility(View.GONE);

                    } else if (checkedId == R.id.motorbikeradio) {
                        carTypeET.setVisibility(View.GONE);
                        carTypeTV.setVisibility(View.GONE);
                        sideCar.setVisibility(View.VISIBLE);
                        sideCarTV.setVisibility(View.VISIBLE);

                    }
                }
            }
        });


    }


}
