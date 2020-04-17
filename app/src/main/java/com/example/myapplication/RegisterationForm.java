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
import android.widget.Toast;

import java.sql.SQLOutput;
import java.util.Calendar;

public class RegisterationForm extends AppCompatActivity {

    Spinner emptype, vehColor;
    TextView clientsTV, bugsTV, projectsTV, carTypeTV, sideCarTV;
    EditText clientsET, bugsET, projectsET, carTypeET, firstNameET, lastNameET, birthYearET, monthlySalaryET, ocpRateET, empIdET, vehModelET, plateNumET;
    RadioGroup vehType, sideCar;
    Button submit;

    String fName, lName, emploType, vehicleType, sideCarVal, carType, vehicleModel, plateNumber, vehicleColor;
    int birthYear, empID, numProj, numClients, numBugs, numPCB;
    double monthlySalary, ocpRate;
    Vehicle vehicle;
    Employee employee;
    DatabaseHelper objhelper;


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
        submit = findViewById(R.id.registerbutton);
        firstNameET = findViewById(R.id.FirstNamee);
        lastNameET = findViewById(R.id.LastNamee);
        birthYearET = findViewById(R.id.BirthYeare);
        monthlySalaryET = findViewById(R.id.MonthlySalarye);
        ocpRateET = findViewById(R.id.Occupationratee);
        empIdET = findViewById(R.id.EmployeeIde);
        vehModelET = findViewById(R.id.editText7);
        plateNumET = findViewById(R.id.editText8);
        vehColor = findViewById(R.id.spinner2);
        objhelper = new DatabaseHelper(this);


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
                fName = firstNameET.getText().toString();
                if (fName.equalsIgnoreCase("")) {
                    Toast.makeText(RegisterationForm.this, "You did not enter the First Name", Toast.LENGTH_SHORT).show();
                    firstNameET.requestFocus();
                    return;

                }

                lName = lastNameET.getText().toString();
                if (lName.equalsIgnoreCase("")) {
                    Toast.makeText(RegisterationForm.this, "You did not enter the Last Name", Toast.LENGTH_SHORT).show();
                    lastNameET.requestFocus();
                    return;

                }
                String fullName = fName + " " + lName;

                if (birthYearET.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(RegisterationForm.this, "You did not enter the Birth Year", Toast.LENGTH_SHORT).show();
                    birthYearET.requestFocus();
                    return;

                }
                birthYear = Integer.parseInt(birthYearET.getText().toString());

                if ((birthYear <= 1900) || (birthYear >= Calendar.getInstance().get(Calendar.YEAR))) {
                    Toast.makeText(RegisterationForm.this, "Enter Birth Year between 1900 and Current Year", Toast.LENGTH_SHORT).show();
                    birthYearET.requestFocus();
                    return;


                }


                if (monthlySalaryET.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(RegisterationForm.this, "You did not enter the Monthly Salary", Toast.LENGTH_SHORT).show();
                    monthlySalaryET.requestFocus();
                    return;

                }

                monthlySalary = Double.parseDouble(monthlySalaryET.getText().toString());

                if (ocpRateET.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(RegisterationForm.this, "You did not enter the Occupation Rate", Toast.LENGTH_SHORT).show();
                    ocpRateET.requestFocus();
                    return;

                }
                ocpRate = Double.parseDouble(ocpRateET.getText().toString());

                if (empIdET.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(RegisterationForm.this, "You did not enter the Employee ID", Toast.LENGTH_SHORT).show();

                    empIdET.requestFocus();
                    return;

                }
                empID = Integer.parseInt(empIdET.getText().toString());

                if (objhelper.checkId(empID)) {
                    Toast.makeText(RegisterationForm.this, "Please enter a Unique Employee ID", Toast.LENGTH_SHORT).show();

                    empIdET.requestFocus();
                    return;

                }

                emploType = emptype.getSelectedItem().toString();

                if (emploType.equalsIgnoreCase("Choose a type")) {
                    Toast.makeText(RegisterationForm.this, "You did not select the Employee Type", Toast.LENGTH_SHORT).show();
                    emptype.setFocusable(true);
                    emptype.setFocusableInTouchMode(true);
                    emptype.requestFocus();
                    return;

                }
                numProj = Integer.parseInt(projectsET.getText().toString());
                numBugs = Integer.parseInt(bugsET.getText().toString());
                numClients = Integer.parseInt(clientsET.getText().toString());
                carType = carTypeET.getText().toString();
                vehicleModel = vehModelET.getText().toString();

                if (vehicleModel.equalsIgnoreCase("")) {
                    Toast.makeText(RegisterationForm.this, "You did not enter the Vehicle Model", Toast.LENGTH_SHORT).show();

                    vehModelET.requestFocus();
                    return;

                }

                plateNumber = plateNumET.getText().toString();
                if (plateNumber.equalsIgnoreCase("")) {
                    Toast.makeText(RegisterationForm.this, "You did not enter the Plate Number", Toast.LENGTH_SHORT).show();

                    plateNumET.requestFocus();
                    return;

                }
                vehicleColor = vehColor.getSelectedItem().toString();

                if (vehicleColor.equalsIgnoreCase("Choose a color")) {
                    Toast.makeText(RegisterationForm.this, "You did not select the Vehicle Color", Toast.LENGTH_SHORT).show();
                    vehColor.setFocusable(true);
                    vehColor.setFocusableInTouchMode(true);
                    vehColor.requestFocus();
                    return;

                }


                int id = vehType.getCheckedRadioButtonId();
                RadioButton r = vehType.findViewById(id);
                vehicleType = r.getText().toString();

                int idd = sideCar.getCheckedRadioButtonId();
                RadioButton ss = sideCar.findViewById(idd);
                sideCarVal = ss.getText().toString();


                if (vehicleType.equalsIgnoreCase("Car")) {
                    sideCarVal = null;
                    if (carType.equalsIgnoreCase("")) {
                        Toast.makeText(RegisterationForm.this, "You did not enter the Car Type", Toast.LENGTH_SHORT).show();
                        carTypeET.requestFocus();

                        return;

                    }


                } else if (vehicleType.equalsIgnoreCase("Motor Bike")) {
                    carType = null;

                    //  vehicle= new Motorcycle(vehicleModel,plateNumber,vehicleColor,vehicleType,sideCarVal);
                }


                if (emploType.equalsIgnoreCase("Manager")) {

                    // employee= new Manager(fullName,birthYear,monthlySalary,ocpRate,empID,emploType,vehicle,numClients);
                    numPCB = numClients;


                } else if (emploType.equalsIgnoreCase("Tester")) {
                    //  employee = new Tester(fullName,birthYear,monthlySalary,ocpRate,empID,emploType,vehicle,numBugs);
                    numPCB = numBugs;


                } else if (emploType.equalsIgnoreCase("Programmer")) {
                    //  employee = new Programmer(fullName,birthYear,monthlySalary,ocpRate,empID,emploType,vehicle,numProj);
                    numPCB = numProj;


                }

                objhelper.addEmployee(empID, fullName, birthYear, monthlySalary, ocpRate, emploType, numPCB, vehicleType, vehicleModel, plateNumber, vehicleColor, carType, sideCarVal);


                // SingletonClass singlobj = SingletonClass.getInstance();
                //singlobj.emplist.add(employee);


                finish();
                Toast.makeText(RegisterationForm.this, "Registeration Successful", Toast.LENGTH_SHORT).show();


            }
        });


    }


}
