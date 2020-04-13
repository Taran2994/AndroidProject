package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EmpDetail extends AppCompatActivity {

    TextView content;
    Button delete;
    int empId;
    String emptype;
    String vehtype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        DatabaseHelper db= new DatabaseHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_detail);
        empId = getIntent().getIntExtra("empID", -1);
        content = findViewById(R.id.contentTV);

      //  SingletonClass obj = SingletonClass.getInstance();
        Employee emp1 = db.getEmployee(empId);
        Vehicle veh1 = emp1.getVehicle();

        String name = emp1.getName();
        int id = emp1.getEmpID();
        int age = emp1.getAge();
        emptype = emp1.getEmpType();
        vehtype = veh1.getCategory();
        String model = veh1.getModel();
        String plate = veh1.getPlateNum();
        String color = veh1.getColor();
        String extra = "";
        Double ocpRate = emp1.getOcpRate();
        Double annualIncome = emp1.getAnnualSalary();
        String empExtra = "";
        int clientsNum, bugsNum, projectsNum;

        if (vehtype.equalsIgnoreCase("Motor Bike")) {
            Motorcycle motorcycle = (Motorcycle) emp1.getVehicle();
            if (motorcycle.getSidecar().equalsIgnoreCase("yes")) {
                extra = "- with a side car";

            } else {
                extra = "- without a side car";
            }

        } else if (vehtype.equalsIgnoreCase("Car")) {
            Car car = (Car) emp1.getVehicle();
            extra = "- Type :" + car.getType();
        }

        if (emptype.equalsIgnoreCase("Manager")) {

            Manager manager = (Manager) emp1;
            clientsNum = manager.getNbClients();
            empExtra = "brought " + clientsNum + " new clients";

        } else if (emptype.equalsIgnoreCase("Tester")) {
            Tester tester = (Tester) emp1;
            bugsNum = tester.getNbBugs();
            empExtra = "corrected " + bugsNum + " bugs";
        } else {
            Programmer programmer = (Programmer) emp1;
            projectsNum = programmer.getNbProjects();
            empExtra = "completed " + projectsNum + " projects";
        }


        content.setText("Name :" + name + ", a " + emptype + "\nID :" + id + "\nAge :" + age + "\nEmployee has a " + vehtype + "\n" +
                " - Model :" + model + "\n - Plate number :" + plate + "\n - Color :" + color + "\n " + extra + "\nOccupation Rate :" + ocpRate + "\nAnnual Income :$ "
                + annualIncome + "\nHe/She has " + empExtra
        );


    }

    public void onDelClick(View v) {
        DatabaseHelper db= new DatabaseHelper(this);
        db.deleteEmployee(empId);
        finish();
       // Intent intent= new Intent(this, MainActivity.class);
      //  startActivity(intent);


    }

    public void onEditClick(View v) {
        EditDetails editDetails = new EditDetails();
        Bundle bundle = new Bundle();
      //  bundle.putInt("Position", position);
        bundle.putString("EmpType",emptype);
        bundle.putString("VehType",vehtype);
        editDetails.setArguments(bundle);
        editDetails.show(getSupportFragmentManager(), "Edit Details");


    }
}