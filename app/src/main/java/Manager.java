public class Manager extends Employee {
    private int nbClients;

    public int getNbClients() {
        return nbClients;
    }

    public void setNbClients(int nbClients) {
        this.nbClients = nbClients;
    }

    public Manager(String name, String age, int birthYear, double monthlySalary, double ocpRate, int nbClients) {
        super(name, age, birthYear, monthlySalary, ocpRate);
        this.nbClients=nbClients;
    }
}
