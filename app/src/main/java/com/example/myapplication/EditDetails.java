package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EditDetails extends AppCompatDialogFragment {

    int empID;
    String etype, vehType;
    TextView clientsTV, bugsTV, projectsTV, empTypeTV, empNameTV, empIDTV;
    EditText clientsET, bugsET, projectsET, ocpRateET, monthlySalET, birthYearET;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_edit_details, null);

        DatabaseHelper objHelper = new DatabaseHelper(getContext());


        Bundle bundle = getArguments();
        empID = bundle.getInt("EmpId");
        etype = bundle.getString("EmpType");
        vehType = bundle.getString("VehType");
        builder.setView(view);
        builder.setTitle("Edit Details");

        Employee employee = objHelper.getEmployee(empID);


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
