public class Programmer extends Employee {
    private int nbProjects;
    private final double gain_Factor_Projects = 200;

    public int getNbProjects() {
        return nbProjects;
    }

    public void setNbProjects(int nbProjects) {
        this.nbProjects = nbProjects;
    }

    public Programmer(String name, String age, int birthYear, double monthlySalary, double ocpRate, int nbProjects) {
        super(name, age, birthYear, monthlySalary, ocpRate);
        this.nbProjects=nbProjects;
    }
    @Override
    public double annualIncome() {

        double base = getBaseSalary();
        double bonus = this.nbProjects * gain_Factor_Projects;

        double totalIncome = base + bonus;
        return totalIncome;


    }
}
