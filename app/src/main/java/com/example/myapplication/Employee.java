package com.example.myapplication;

import java.util.Calendar;

public class Employee {
    private String name;
    private int age;
    private int birthYear;
    private double monthlySalary;
    private double ocpRate;
    private double baseSalary;
    private int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    private double annualSalary;
    private String empType;

    public String getEmpType() {
        return empType;
    }

    public void setEmpType(String empType) {
        this.empType = empType;
    }


    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Employee(String name, int birthYear, double monthlySalary, double ocpRate, String empType) {
        this.name = name;
        this.empType=empType;

        this.birthYear = birthYear;
        this.age = this.currentYear - this.birthYear;
        this.monthlySalary = monthlySalary;

        if (ocpRate < 10) {
            this.ocpRate = 10.00;
        } else if (ocpRate > 100) {
            this.ocpRate = 100;
        } else {
            this.ocpRate = ocpRate;
        }
        baseSalary = this.monthlySalary * 12 * (this.ocpRate / 100);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }


    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }


    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public double getOcpRate() {
        return ocpRate;
    }

    public void setOcpRate(double ocpRate) {
        this.ocpRate = ocpRate;
    }

    public double annualIncome()   //for subclasses to override
    {
        return 0;
    }

}

