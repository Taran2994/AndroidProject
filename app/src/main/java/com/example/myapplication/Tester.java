package com.example.myapplication;

public class Tester extends Employee {
    private int nbBugs;
    private final double gain_Factor_Error = 10;

    public int getNbBugs() {
        return nbBugs;
    }

    public void setNbBugs(int nbBugs) {
        this.nbBugs = nbBugs;
    }

    public Tester(String name, String age, int birthYear, double monthlySalary, double ocpRate, String empType, int nbBugs) {
        super(name,birthYear, monthlySalary, ocpRate, empType);
        this.nbBugs=nbBugs;
        setAnnualSalary(annualIncome());
    }

    @Override
    public double annualIncome() {

        double base = getBaseSalary();
        double bonus = this.nbBugs * gain_Factor_Error;

        double totalIncome = base + bonus;
        return totalIncome;


    }
}
