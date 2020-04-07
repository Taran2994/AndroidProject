package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView listView;
    ArrayList<Employee> emlist = SingletonClass.getInstance().emplist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);



    }

    @Override
    protected void onStart() {
        super.onStart();
        EmployeeAdapter empAdapter = new EmployeeAdapter(this, R.layout.emp_adapter_layout, emlist);
        listView.setAdapter(empAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent= new Intent(MainActivity.this, EmpDetail.class);
                intent.putExtra("empPosition", position);
                startActivity(intent);


            }
        });



    }

    public void openn(View view) {
        Intent intent = new Intent(this, RegisterationForm.class);
        startActivity(intent);

    }


}
