package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class EmpDetail extends AppCompatActivity {

    TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_detail);
        int position = getIntent().getIntExtra("empPosition", -1);
        content = findViewById(R.id.contentTV);

        SingletonClass obj = SingletonClass.getInstance();
        Employee emp1 = obj.emplist.get(position);
        Vehicle veh1 = emp1.getVehicle();

        String name = emp1.getName();
        String id = emp1.getEmpID();
        int age = emp1.getAge();
        String emptype = emp1.getEmpType();
        String vehtype = veh1.getCategory();
        String model = veh1.getModel();
        String plate = veh1.getPlateNum();
        String color = veh1.getColor();
        String extra="";
        Double ocpRate = emp1.getOcpRate();
        Double annualIncome = emp1.getAnnualSalary();
        String empExtra="";
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


        content.setText("Name :" + name + ", a " + emptype + "\n ID :" + id + "\n Age :" + age + "\n Employee has a " + vehtype + "\n" +
                        " - Model :"+model+"\n - Plate number :"+plate+"\n - Color :"+color+"\n "+extra+"\n Occupation Rate :"+ocpRate+"\n Annual Income :$ "
                        +annualIncome+"\n He/She has "+empExtra
                         );


    }
}