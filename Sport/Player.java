public class Player {
    public String name;
    public int wins;

    public Player(String name){
        this.name = name;
        this.wins = 0;
    }

    public int getPlayerWins(){
        return wins;
    }

}
