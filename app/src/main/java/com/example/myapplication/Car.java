package com.example.myapplication;

public class Car extends Vehicle {

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Car(String model, String plateNum, String color, String category, String type) {
        super(model, plateNum, color, category);
        this.type=type;
    }
}
