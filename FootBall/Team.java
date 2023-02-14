import java.util.ArrayList;

public class Team {
    public String teamName, coache;
    public int goals, wins, losses, nulls, pts;
    public ArrayList<Player>players;
    
    public Team(String teamName, String coache, ArrayList<Player>players){
        this.teamName = teamName;
        this.coache = coache;
        this.goals = 0;
        this.wins = 0;
        this.losses = 0;
        this.nulls = 0;
        this.pts = 0;
        this.players = players;
    }

    public void setGoals(int goals) {
         this.goals += goals;
    }

    public int getGoals() {
        return goals;
    }

    public void setWins() {
        wins++;
        pts+=3;
    }

    public int getWins() {
        return wins;
    }

    public void setLosses() {
        losses++;
    }
    
    public int getLosses() {
        return losses;
    }
    
    public void setNulls() {
        nulls++;
        pts++;
    }
    
    public int getNulls() {
        return nulls;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getPts() {
        return pts;
    }

    public void lineUp() {
        System.out.println("\nthe lineup for " + this.teamName + ":");
        for(Player player : players){
            System.out.println(player.playerName + ". position: " + player.position);
        }
        System.out.println("\n-------------------------\n");

    }


}
