package Sport.Sports;

import java.util.ArrayList;
import java.util.HashMap;

import Sport.Teams.Teams;
import Sport.Teams.Players.AbstractPlayer;

public abstract class AbstractSports {

    protected ArrayList<AbstractPlayer> playerList = new ArrayList<>();
    protected ArrayList<Teams> teams = new ArrayList<>();
    protected HashMap<Teams, Integer> scoreMap;
    protected int duration;
    protected String location;
    protected AbstractPlayer winner;

    /* GETTERS */
    public ArrayList<AbstractPlayer> getPlayerList() {
        return playerList;
    }
    public ArrayList<Teams> getTeams() {
        return teams;
    }
    public HashMap<Teams, Integer> getScoreMap() {
        return scoreMap;
    }
    public int getDuration() {
        return duration;
    }
    public String getLocation() {
        return location;
    }
    public AbstractPlayer getWinner() {
        return winner;
    }

    

    
}
