package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class RegisterationForm extends AppCompatActivity {

    Spinner emptype, vehColor;
    TextView clientsTV, bugsTV, projectsTV, carTypeTV, sideCarTV;
    EditText clientsET, bugsET, projectsET, carTypeET, firstNameET, lastNameET, birthYearET, monthlySalaryET, ocpRateET,empIdET,vehModelET, plateNumET;
    RadioGroup vehType, sideCar;
    Button submit;

    String fName, lName , empID, emploType, vehicleType, sideCarVal, carType, vehicleModel, plateNumber, vehicleColor;
    int birthYear, numProj, numClients, numBugs;
    double monthlySalary, ocpRate;


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
        submit=findViewById(R.id.registerbutton);
        firstNameET=findViewById(R.id.FirstNamee);
        lastNameET=findViewById(R.id.LastNamee);
        birthYearET=findViewById(R.id.BirthYeare);
        monthlySalaryET=findViewById(R.id.MonthlySalarye);
        ocpRateET=findViewById(R.id.Occupationratee);
        empIdET=findViewById(R.id.EmployeeIde);
        vehModelET=findViewById(R.id.editText7);
        plateNumET=findViewById(R.id.editText8);
        vehColor=findViewById(R.id.spinner2);







       // int id= vehType.getCheckedRadioButtonId();
       // RadioButton r=vehType.findViewById(id);
        //vehicleType= r.getText().toString();





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
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fName= firstNameET.getText().toString();
                lName=lastNameET.getText().toString();
                birthYear=Integer.parseInt(birthYearET.getText().toString());
                monthlySalary=Double.parseDouble(monthlySalaryET.getText().toString());
                ocpRate= Double.parseDouble(ocpRateET.getText().toString());
                empID=empIdET.getText().toString();
                emploType=emptype.getSelectedItem().toString();
                numProj=Integer.parseInt(projectsET.getText().toString());
                numBugs= Integer.parseInt(bugsET.getText().toString());
                numClients=Integer.parseInt(clientsET.getText().toString());
                carType=carTypeET.getText().toString();
                vehicleModel=vehModelET.getText().toString();
                plateNumber=plateNumET.getText().toString();
                vehicleColor=vehColor.getSelectedItem().toString();




                if(emploType.equalsIgnoreCase("Manager"))
                {
               //   Employee e1= new Manager();
                }
               else if(emploType.equalsIgnoreCase("Tester"))
                {
                  //  Employee e1= new Tester();

                }
               else if(emploType.equalsIgnoreCase("Programmer"))
                {
                 //   Employee e1= new Programmer();

                }

            }
        });


    }


}
