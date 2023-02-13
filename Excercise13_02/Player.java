package Excercise13_02;

public class Player {
    protected String name;
    protected int nb_win;
    protected int nb_lose;
    protected int perf;

    public Player(String name, int nb_win,int perf) {
        this.name = name;
        this.nb_win = nb_win;
        this.nb_win = nb_lose;
        this.perf = perf;
    }

    @Override
    public String toString() {
        return "Player [name=" + name + ", nb_win=" + nb_win + ", nb_lose=" + nb_lose + ", perf=" + perf + "]";
    }

    

    

}
