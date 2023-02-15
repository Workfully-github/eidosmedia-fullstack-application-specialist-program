package Excercise13And14_02;

public class Player {
    protected String name;
    protected int nb_wins;
    protected int nb_losses;
    protected int perf;

    public Player(String name, int nb_wins,int perf) {
        this.name = name;
        this.nb_wins = nb_wins;
        this.nb_wins = nb_losses;
        this.perf = perf;
    }

    @Override
    public String toString() {
        return "Player [name=" + name + ", nb_wins=" + nb_wins + ", nb_losses=" + nb_losses + ", perf=" + perf + "] ";
    }

    public int getPerf() {
        return perf;
    }

    

    

}
