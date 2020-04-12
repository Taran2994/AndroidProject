package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView listView;
    ArrayList<Employee> emlist;
    DatabaseHelper mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);


    }

    @Override
    protected void onStart() {
        super.onStart();


        Cursor cursor = mDatabase.getAllEmployees();

        if (cursor.moveToFirst()) {
            do {
                Vehicle vehicle;
                if (cursor.getString(7).equalsIgnoreCase("car")) {
                    vehicle = new Car(cursor.getString(8),
                            cursor.getString(9),
                            cursor.getString(10),
                            cursor.getString(7),
                            cursor.getString(11)
                    );

                } else {

                    vehicle = new Motorcycle(cursor.getString(8),
                            cursor.getString(9),
                            cursor.getString(10),
                            cursor.getString(7),
                            cursor.getString(12)
                    );


                }

                if (cursor.getString(5).equalsIgnoreCase("Manager")) {
                    emlist.add(new Manager(cursor.getString(1),
                            cursor.getInt(2),
                            cursor.getDouble(3),

                            cursor.getDouble(4),

                            cursor.getInt(0),

                            cursor.getString(5),
                            vehicle,
                            cursor.getInt(6)


                    ));

                } else if (cursor.getString(5).equalsIgnoreCase("Tester")) {
                    emlist.add(new Tester(cursor.getString(1),
                            cursor.getInt(2),
                            cursor.getDouble(3),

                            cursor.getDouble(4),

                            cursor.getInt(0),

                            cursor.getString(5),
                            vehicle,
                            cursor.getInt(6)


                    ));

                } else if (cursor.getString(5).equalsIgnoreCase("Programmer")) {
                    emlist.add(new Programmer(cursor.getString(1),
                            cursor.getInt(2),
                            cursor.getDouble(3),

                            cursor.getDouble(4),

                            cursor.getInt(0),

                            cursor.getString(5),
                            vehicle,
                            cursor.getInt(6)


                    ));

                }


            } while (cursor.moveToNext());
            cursor.close();


            EmployeeAdapter empAdapter = new EmployeeAdapter(this, R.layout.emp_adapter_layout, emlist);
            listView.setAdapter(empAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent = new Intent(MainActivity.this, EmpDetail.class);
                    intent.putExtra("empPosition", position);
                    startActivity(intent);


                }
            });
        }


        }

        public void openn (View view){

            Intent intent = new Intent(this, RegisterationForm.class);
            startActivity(intent);

        }


    }
