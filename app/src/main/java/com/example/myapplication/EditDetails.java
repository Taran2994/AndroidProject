package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class EditDetails extends AppCompatDialogFragment {

    int empID, numPCB, numClients, numBugs, numProj;
    String etype, vehType, sideCarVal, carType;
    TextView clientsTV, bugsTV, projectsTV, empTypeTV, empNameTV, empIDTV;
    EditText clientsET, bugsET, projectsET, ocpRateET, monthlySalET, birthYearET;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_edit_details, null);

        final DatabaseHelper objHelper = new DatabaseHelper(getContext());


        Bundle bundle = getArguments();
        empID = bundle.getInt("EmpId");
        etype = bundle.getString("EmpType");
        vehType = bundle.getString("VehType");
        builder.setView(view);
        builder.setTitle("Edit Details");

        final Employee employee = objHelper.getEmployee(empID);


        clientsET = view.findViewById(R.id.numClientsET);
        clientsTV = view.findViewById(R.id.numClientsTV);
        bugsET = view.findViewById(R.id.numBugsET);
        bugsTV = view.findViewById(R.id.numBugsTV);
        projectsET = view.findViewById(R.id.numProjectsET);
        projectsTV = view.findViewById(R.id.numProjectsTV);
        empIDTV = view.findViewById(R.id.empIDTV);
        empNameTV = view.findViewById(R.id.empNameTV);
        empTypeTV = view.findViewById(R.id.empTypeTV);
        birthYearET = view.findViewById(R.id.birthYearET);
        monthlySalET = view.findViewById(R.id.monthlySalET);
        ocpRateET = view.findViewById(R.id.ocpRateET);


        if (etype.equalsIgnoreCase("Manager")) {

            Manager manager = (Manager) objHelper.getEmployee(empID);
            clientsET.setText("" + manager.getNbClients());
            clientsET.setVisibility(View.VISIBLE);
            clientsTV.setVisibility(View.VISIBLE);
            bugsET.setVisibility(View.GONE);
            bugsTV.setVisibility(View.GONE);
            projectsET.setVisibility(View.GONE);
            projectsTV.setVisibility(View.GONE);


        } else if (etype.equalsIgnoreCase("Tester")) {

            Tester tester = (Tester) objHelper.getEmployee(empID);
            bugsET.setText("" + tester.getNbBugs());

            bugsET.setVisibility(View.VISIBLE);
            bugsTV.setVisibility(View.VISIBLE);
            clientsET.setVisibility(View.GONE);
            clientsTV.setVisibility(View.GONE);
            projectsET.setVisibility(View.GONE);
            projectsTV.setVisibility(View.GONE);


        } else if (etype.equalsIgnoreCase("Programmer")) {

            Programmer programmer = (Programmer) objHelper.getEmployee(empID);
            projectsET.setText("" + programmer.getNbProjects());
            projectsET.setVisibility(View.VISIBLE);
            projectsTV.setVisibility(View.VISIBLE);
            bugsET.setVisibility(View.GONE);
            bugsTV.setVisibility(View.GONE);
            clientsET.setVisibility(View.GONE);
            clientsTV.setVisibility(View.GONE);

        }

        empIDTV.setText("" + empID);
        empNameTV.setText(employee.getName());
        empTypeTV.setText(etype);
        birthYearET.setText("" + employee.getBirthYear());
        monthlySalET.setText("" + employee.getMonthlySalary());
        ocpRateET.setText("" + employee.getOcpRate());




        builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                numBugs= Integer.parseInt(bugsET.getText().toString());

                numClients= Integer.parseInt(clientsET.getText().toString());

                numProj= Integer.parseInt(projectsET.getText().toString());
                if(birthYearET.getText().toString().equalsIgnoreCase(""))
                {
                    Toast.makeText(getContext(), "You did not enter the Birth Year", Toast.LENGTH_SHORT).show();
                    birthYearET.requestFocus();
                    return;

                }
                int brthYr= Integer.parseInt(birthYearET.getText().toString());
                if ((brthYr <= 1900) || (brthYr >= Calendar.getInstance().get(Calendar.YEAR))) {
                    Toast.makeText(getContext(), "Enter Birth Year between 1900 and Current Year", Toast.LENGTH_SHORT).show();
                    birthYearET.requestFocus();
                    return;


                }
                if(monthlySalET.getText().toString().equalsIgnoreCase(""))
                {
                    Toast.makeText(getContext(), "You did not enter the Monthly Salary", Toast.LENGTH_SHORT).show();
                    monthlySalET.requestFocus();
                    return;

                }
                if(ocpRateET.getText().toString().equalsIgnoreCase(""))
                {
                    Toast.makeText(getContext(), "You did not enter the Occupation Rate", Toast.LENGTH_SHORT).show();
                    ocpRateET.requestFocus();
                    return;

                }

                if (vehType.equalsIgnoreCase("Car")) {
                    sideCarVal = null;
                    Car car= (Car) employee.getVehicle();
                    carType= car.getType();



                } else if (vehType.equalsIgnoreCase("Motor Bike")) {
                    carType = null;
                    Motorcycle motorcycle = (Motorcycle) employee.getVehicle();
                    sideCarVal= motorcycle.getSidecar();


                }


                if (etype.equalsIgnoreCase("Manager")) {
                    if(clientsET.getText().toString().equalsIgnoreCase(""))
                    {
                        Toast.makeText(getContext(), "You did not enter the Number Of Clients", Toast.LENGTH_SHORT).show();
                        clientsET.requestFocus();
                        return;

                    }


                    numPCB = numClients;


                } else if (etype.equalsIgnoreCase("Tester")) {

                    if(bugsET.getText().toString().equalsIgnoreCase(""))
                    {
                        Toast.makeText(getContext(), "You did not enter the Number Of Bugs", Toast.LENGTH_SHORT).show();
                        bugsET.requestFocus();
                        return;

                    }

                    numPCB = numBugs;


                } else if (etype.equalsIgnoreCase("Programmer")) {

                    if(projectsET.getText().toString().equalsIgnoreCase(""))
                    {
                        Toast.makeText(getContext(), "You did not enter the Number Of Projects", Toast.LENGTH_SHORT).show();
                        projectsET.requestFocus();
                        return;

                    }
                    numPCB = numProj;


                }





                Vehicle vehicle= employee.getVehicle();
                objHelper.updateEmployee(empID,employee.getName(),Integer.parseInt(birthYearET.getText().toString()),Double.parseDouble(monthlySalET.getText().toString()),
                        Double.parseDouble(ocpRateET.getText().toString()),etype,numPCB,vehType, vehicle.getModel(),vehicle.getPlateNum(),vehicle.getColor(),carType,sideCarVal );



                Intent intent = new Intent(getContext(), EmpDetail.class);
                intent.putExtra("empID", empID);
                startActivity(intent);

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
