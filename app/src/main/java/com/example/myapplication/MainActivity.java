package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void openn(View view) {
        Intent intent = new Intent(this, RegisterationForm.class);
           startActivity(intent);

    }
    public void print(View view)
    {

       SingletonClass singlobj= SingletonClass.getInstance();
        //System.out.println("The size is "+ singlobj.emplist.size());
      for(int i=0;i<singlobj.emplist.size();i++)
        {
           Employee emp= singlobj.emplist.get(i);
            System.out.println(emp.getName());
            System.out.println(emp.getEmpType());
        }



    }
}
