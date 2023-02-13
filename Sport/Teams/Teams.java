package Sport.Teams;

import java.util.ArrayList;
import java.util.HashMap;

import Sport.Teams.Players.AbstractPlayer;

public class Teams {

    private String name;
    private String color;
    private int score;
    private ArrayList<AbstractPlayer> listOfPlayers = new ArrayList<>();
    private HashMap<AbstractPlayer, Integer> performanceRatingList = new HashMap<>();

    /* Constructor */
    public Teams(
        String name, 
        String color, 
        ArrayList<AbstractPlayer> listOfPlayers,
        HashMap<AbstractPlayer, Integer> performanceRating
        ){

        this.name = name;
        this.color = color;
        this.listOfPlayers = listOfPlayers;
        this.performanceRatingList = performanceRating;

        for (AbstractPlayer abstractPlayer : listOfPlayers) {
            this.score += abstractPlayer.getScores();
        }
        
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getScore() {
        return score;
    }

    public ArrayList<AbstractPlayer> getListOfPlayers() {
        return listOfPlayers;
    }

    public HashMap<AbstractPlayer, Integer> getPerformanceRatingList() {
        return performanceRatingList;
    }

    

    
}
