package com.example.myapplication;

public class Motorcycle extends Vehicle {
    private String sidecar;

    public String getSidecar() {
        return sidecar;
    }

    public void setSidecar(String sidecar) {
        this.sidecar = sidecar;
    }

    public Motorcycle(String model, String plateNum, String color, String category, String sidecar) {
        super(model, plateNum, color, category);
        this.sidecar=sidecar;
    }
}
