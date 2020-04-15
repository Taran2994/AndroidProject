package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SwipeDetector swipeDetector;
    EditText search;
    ListView listView;
    ArrayList<Employee> emlist;
    DatabaseHelper mDatabase;
     EmployeeAdapter empAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        search= findViewById(R.id.searchET);




    }

    @Override
    protected void onStart() {
        super.onStart();
        search.setText("");







    emlist = new ArrayList<Employee>();

        mDatabase = new DatabaseHelper(this);

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


             empAdapter = new EmployeeAdapter(this, R.layout.emp_adapter_layout, emlist);
            listView.setAdapter(empAdapter);

             swipeDetector = new SwipeDetector();

            listView.setOnTouchListener(swipeDetector);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (swipeDetector.swipeDetected()) {
                        if ((swipeDetector.getAction() == SwipeDetector.Action.RL) || (swipeDetector.getAction() == SwipeDetector.Action.LR)) {

                            mDatabase.deleteEmployee(emlist.get(position).getEmpID());
                            recreate();
                            Toast.makeText(getApplicationContext(), "Employee Deleted", Toast.LENGTH_SHORT).show();



                        }

                        }
                    else {
                        Intent intent = new Intent(MainActivity.this, EmpDetail.class);
                        intent.putExtra("empID", emlist.get(position).getEmpID());
                        startActivity(intent);
                    }




                    }
                });

            search.addTextChangedListener(new TextWatcher() {
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {





                    // Call back the Adapter with current character to Filter
                    empAdapter.getFilter().filter(s.toString());
                    System.out.println("Change");

                }

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count,int after) {
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });


            }


        }

        public void openn (View view){

            Intent intent = new Intent(this, RegisterationForm.class);
            startActivity(intent);

        }


    }
