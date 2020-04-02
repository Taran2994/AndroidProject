public class Tester extends Employee {
    private int nbBugs;

    public int getNbBugs() {
        return nbBugs;
    }

    public void setNbBugs(int nbBugs) {
        this.nbBugs = nbBugs;
    }

    public Tester(String name, String age, int birthYear, double monthlySalary, double ocpRate, int nbBugs) {
        super(name, age, birthYear, monthlySalary, ocpRate);
        this.nbBugs=nbBugs;
    }
}
