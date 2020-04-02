public class Employee {
    private String name;
    private String age;
    private int birthYear;
    private double monthlySalary;
    private double ocpRate;

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
}
