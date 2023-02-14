package Sport.Teams;

import java.util.ArrayList;
import java.util.HashMap;

import Sport.Scores.Score;
import Sport.Teams.Players.AbstractPlayer;

public class Teams {

    private String name;
    private ArrayList<Score> score;
    private int totalScore;
    private ArrayList<AbstractPlayer> listOfPlayers = new ArrayList<>();
    private HashMap<AbstractPlayer, Integer> performanceRatingList = new HashMap<>();


    /* Empty Constructor */
    public Teams(){

    }
    

    /* Constructor */
    public Teams(
        String name,
        ArrayList<AbstractPlayer> listOfPlayers
    ){
        this.name = name;
        this.listOfPlayers = listOfPlayers;
    }

    public Teams(
        String name, 
        String color, 
        ArrayList<AbstractPlayer> listOfPlayers,
        HashMap<AbstractPlayer, Integer> performanceRating
        ){

        this.name = name;
        this.listOfPlayers = listOfPlayers;
        this.performanceRatingList = performanceRating;

/*         for (AbstractPlayer abstractPlayer : listOfPlayers) {
            this.score += abstractPlayer.getScores();
        } */
        
    }

    public String getName() {
        return name;
    }

    public ArrayList<AbstractPlayer> getListOfPlayers() {
        return listOfPlayers;
    }

    public HashMap<AbstractPlayer, Integer> getPerformanceRatingList() {
        return performanceRatingList;
    }

    public ArrayList<Score> getScore() {
        return score;
    }

    public int getTotalScore() {
        return totalScore;
    }
}
