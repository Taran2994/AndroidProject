package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="EmployeeDatabase";
    private static final String TABLE_NAME = "employees";
    private static final String COLUMN_ID = "emp_id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_BIRTHYEAR="birth_year";
    private static final String COLUMN_MONTHLY_SALARY="monthly_salary";
    private static final String COLUMN_OCP_RATE="ocp_rate";
    private static final String COLUMN_EMP_TYPE="emp_type";
    private static final String COLUMN_NUMBER="num_cpb";
    private static final String COLUMN_VEHICLE_TYPE="veh_type";
    private static final String COLUMN_VEHICLE_MODEL="model";
    private static final String COLUMN_VEHICLE_PLATE="plate_number";
    private static final String COLUMN_VEHICLE_COLOR="color";
    private static final String COLUMN_CAR_TYPE="car_type";
    private static final String COLUMN_SIDE_CAR="side_car";
    private static final String COLUMN_DEPT = "department";
    private static final String COLUMN_JOIN_DATE = "joiningdate";
    private static final String COLUMN_SALARY = "salary";




    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

      //  String sql="CREATE TABLE "+TABLE_NAME+ "("+
      //          COLUMN_ID+ " INTEGER NOT NULL CONSTRAINT employee_pk PRIMARY KEY, "+


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
