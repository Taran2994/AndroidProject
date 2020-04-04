package com.example.myapplication;

public class Manager extends Employee {
    private int nbClients;
    private final double gain_Factor_Client = 500;
    private final double gain_Factor_Travel = 100;

    public int getNbClients() {
        return nbClients;
    }

    public void setNbClients(int nbClients) {
        this.nbClients = nbClients;
    }

    public Manager(String name, int birthYear, double monthlySalary, double ocpRate,  String empID,String empType, Vehicle vehicle, int nbClients) {
        super(name, birthYear, monthlySalary, ocpRate, empID, empType,vehicle);
        this.nbClients = nbClients;
        setAnnualSalary(annualIncome());
    }

    @Override
    public double annualIncome() {

        double base = getBaseSalary();
        double bonus = this.nbClients * gain_Factor_Client;

        double totalIncome = base + bonus;
        return totalIncome;


    }
}
