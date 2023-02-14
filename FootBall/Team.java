import java.util.ArrayList;

public class Team {
    public String teamName, coache;
    public int goals, wins, losses, nulls;
    public ArrayList<Player>players;
    
    public Team(String teamName, String coache, ArrayList<Player>players){
        this.teamName = teamName;
        this.coache = coache;
        this.goals = 0;
        this.wins = 0;
        this.losses = 0;
        this.nulls = 0;
        this.players = players;
    }
    
    public void setGoals(int goals) {
         this.goals += goals;
    }

    public int getGoals() {
        return goals;
    }

    public void lineUp() {
        System.out.println("\nthe lineup for " + this.teamName + ":");
        for(Player player : players){
            System.out.println(player.playerName + ". position: " + player.position);
        }
        System.out.println("\n-------------------------\n");

    }


}
