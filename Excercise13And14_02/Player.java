package Excercise13And14_02;

public class Player {
    protected String name;
    protected int nb_wins;
    protected int nb_losses;
    protected int perf;
    protected int numberGoals = 0;

    public Player(String name, int nb_wins,int perf) {
        this.name = name;
        this.nb_wins = nb_wins;
        this.nb_wins = nb_losses;
        this.perf = perf;
    }

    public void addGoal(){
        this.numberGoals += 1;
    }

    @Override
    public String toString() {
        return "Player [name=" + name + ", nb_wins=" + nb_wins + ", nb_losses=" + nb_losses + ", perf=" + perf +", goals=" + numberGoals + "] \n";
    }

    public int getPerf() {
        return perf;
    }
    public int getNumberGoals() {
        return numberGoals;
    }

    

    

}
