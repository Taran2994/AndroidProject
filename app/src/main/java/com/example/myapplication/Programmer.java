package com.example.myapplication;

public class Programmer extends Employee {
    private int nbProjects;
    private final double gain_Factor_Projects = 200;

    public int getNbProjects() {
        return nbProjects;
    }

    public void setNbProjects(int nbProjects) {
        this.nbProjects = nbProjects;
    }

    public Programmer(String name, int birthYear, double monthlySalary, double ocpRate, int empID, String empType, Vehicle vehicle,int nbProjects) {
        super(name,birthYear, monthlySalary, ocpRate,  empID, empType, vehicle);
        this.nbProjects=nbProjects;
        setAnnualSalary(annualIncome());
    }

    private double annualIncome() {

        double base = getBaseSalary();
        double bonus = this.nbProjects * gain_Factor_Projects;

        double totalIncome = base + bonus;
        return totalIncome;


    }
}
