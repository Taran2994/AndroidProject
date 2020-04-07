package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class EmpDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_detail);
        int position= getIntent().getIntExtra("empPosition",-1);
        if(position==-1)
        {
            System.out.println("no data");
        }
        else{
            System.out.println("position is "+position);
        }
    }
}