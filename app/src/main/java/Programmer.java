public class Programmer extends Employee {
    private int nbProjects;

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
}
