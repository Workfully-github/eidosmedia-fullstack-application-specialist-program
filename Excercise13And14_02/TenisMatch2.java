package Excercise13And14_02;

import java.util.ArrayList;
import java.util.HashMap;

public class TenisMatch2 {

    private ArrayList<Player> players =new ArrayList<>();
    private int duration;
    private HashMap<Player, Integer> score = new HashMap<Player,Integer>();
    private String location;
    private Player winner;
    public TenisMatch2(ArrayList<Player> players, int duration, HashMap<Player, Integer> score, String location) {
        this.players = players;
        this.duration = duration;
        this.score = score;
        this.location = location;
    }

    public void showMatchInfos(){
        System.out.print("Welcome to the match beteen " + players.get(0).name + " vs " + players.get(1).name);
        System.out.print("The game is played at " + location);
        System.out.print("The first score is " + getReadableFinalScore());
        System.out.print("The match duration was " + duration);
    }

    public Player getMatchWinner(){
        if(score.get(players.get(0)) > score.get(players.get(1))){
            return players.get(0);
        }
        else if(score.get(players.get(0)) < score.get(players.get(1))){
            return players.get(1);
        }
        else {
            return null;
        }
        
    }

    public String getReadableFinalScore(){
        return players.get(0).name + " " + score.get(players.get(0)) + " - " 
        + score.get(players.get(1)) + " " + players.get(0).name;
    }
    
    
}
