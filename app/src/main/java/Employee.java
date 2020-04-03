public class Employee {
    private String name;
    private String age;
    private int birthYear;
    private double monthlySalary;
    private double ocpRate;
    private double baseSalary;


    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Employee(String name, String age, int birthYear, double monthlySalary, double ocpRate) {
        this.name = name;
        this.age = age;
        this.birthYear = birthYear;
        this.monthlySalary = monthlySalary;

        if(ocpRate<10)
        {
            this.ocpRate=10.00;
        }
        else if(ocpRate>100)
        {
            this.ocpRate=100;
        }
        else{
            this.ocpRate=ocpRate;
        }
        baseSalary=this.monthlySalary*12*(this.ocpRate/100);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
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

