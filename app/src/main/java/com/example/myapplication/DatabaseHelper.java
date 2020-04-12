package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "EmployeeDatabase";
    private static final String TABLE_NAME = "employees";
    private static final String COLUMN_ID = "emp_id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_BIRTHYEAR = "birth_year";
    private static final String COLUMN_MONTHLY_SALARY = "monthly_salary";
    private static final String COLUMN_OCP_RATE = "ocp_rate";
    private static final String COLUMN_EMP_TYPE = "emp_type";
    private static final String COLUMN_NUMBER = "num_cpb";
    private static final String COLUMN_VEHICLE_TYPE = "veh_type";
    private static final String COLUMN_VEHICLE_MODEL = "model";
    private static final String COLUMN_VEHICLE_PLATE = "plate_number";
    private static final String COLUMN_VEHICLE_COLOR = "color";
    private static final String COLUMN_CAR_TYPE = "car_type";
    private static final String COLUMN_SIDE_CAR = "side_car";


    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_ID + " INTEGER NOT NULL CONSTRAINT employee_pk PRIMARY KEY, " +
                COLUMN_NAME + " varchar(200) NOT NULL, " +
                COLUMN_BIRTHYEAR + " INTEGER NOT NULL, " +
                COLUMN_MONTHLY_SALARY + " DOUBLE NOT NULL, " +
                COLUMN_OCP_RATE + " DOUBLE NOT NULL, " +
                COLUMN_EMP_TYPE + " varchar(200) NOT NULL, " +
                COLUMN_NUMBER + " INTEGER NOT NULL, " +
                COLUMN_VEHICLE_TYPE + " VARCHAR(200) NOT NULL, " +
                COLUMN_VEHICLE_MODEL + " VARCHAR(200) NOT NULL, " +
                COLUMN_VEHICLE_PLATE + " VARCHAR(200) NOT NULL, " +
                COLUMN_VEHICLE_COLOR + " VARCHAR(200) NOT NULL, " +
                COLUMN_CAR_TYPE + " VARCHAR(200), " +
                COLUMN_SIDE_CAR + " VARCHAR(200) );";
        db.execSQL(sql);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";
        db.execSQL(sql);
        onCreate(db);

    }

    public boolean addEmployee(int id, String name, int birthYear, double mSalary, double ocpRate,
                               String empType, int numberCPB, String vehType, String vehModel,
                               String plate, String color, String carType, String sideCar) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ID, id);
        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_BIRTHYEAR, birthYear);
        cv.put(COLUMN_MONTHLY_SALARY, mSalary);
        cv.put(COLUMN_OCP_RATE, ocpRate);
        cv.put(COLUMN_EMP_TYPE, empType);
        cv.put(COLUMN_NUMBER, numberCPB);
        cv.put(COLUMN_VEHICLE_TYPE, vehType);
        cv.put(COLUMN_VEHICLE_MODEL, vehModel);
        cv.put(COLUMN_VEHICLE_PLATE, plate);
        cv.put(COLUMN_VEHICLE_COLOR, color);
        cv.put(COLUMN_CAR_TYPE, carType);
        cv.put(COLUMN_SIDE_CAR, sideCar);

        // the insert method returns row number if the insertion is successful and -1 if unsuccessful
        return sqLiteDatabase.insert(TABLE_NAME, null, cv) != -1;

    }

    public Cursor getAllEmployees() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }


    public boolean updateEmployee(int id, String name, int birthYear, double mSalary, double ocpRate,
                                  String empType, String numberCPB, String vehType, String vehModel,
                                  String plate, String color, String carType, String sideCar) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_BIRTHYEAR, birthYear);
        cv.put(COLUMN_MONTHLY_SALARY, mSalary);
        cv.put(COLUMN_OCP_RATE, ocpRate);
        cv.put(COLUMN_EMP_TYPE, empType);
        cv.put(COLUMN_NUMBER, numberCPB);
        cv.put(COLUMN_VEHICLE_TYPE, vehType);
        cv.put(COLUMN_VEHICLE_MODEL, vehModel);
        cv.put(COLUMN_VEHICLE_PLATE, plate);
        cv.put(COLUMN_VEHICLE_COLOR, color);
        cv.put(COLUMN_CAR_TYPE, carType);
        cv.put(COLUMN_SIDE_CAR, sideCar);

        // this method returns the number of rows affected
        return sqLiteDatabase.update(TABLE_NAME, cv, COLUMN_ID + "=?", new String[]{String.valueOf(id)}) > 0;


    }

    public boolean deleteEmployee(int id) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        // the delete method returns the number of rows affected
        return sqLiteDatabase.delete(TABLE_NAME, COLUMN_ID + "=?", new String[]{String.valueOf(id)}) > 0;
    }


}
