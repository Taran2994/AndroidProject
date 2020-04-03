package com.example.myapplication;

public class Vehicle {

    private String model;
    private String plateNum;
    private String color;
    private String category;

    public Vehicle(String model, String plateNum, String color, String category) {
        this.model = model;
        this.plateNum = plateNum;
        this.color = color;
        this.category = category;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlateNum() {
        return plateNum;
    }

    public void setPlateNum(String plateNum) {
        this.plateNum = plateNum;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
