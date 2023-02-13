package Excercise13_02.FootBall;

import java.util.ArrayList;
import java.util.HashMap;

public class FootBallMatch {
    private ArrayList<FootBallTeam> teams = new ArrayList<>();
    private int duration;
    private HashMap<FootBallTeam, Integer> score = new HashMap<FootBallTeam,Integer>();
    private String location;
    private FootBallTeam winner;

    public FootBallMatch(ArrayList<FootBallTeam> teams, int duration, HashMap<FootBallTeam, Integer> score,
            String location) {
        this.teams = teams;
        this.duration = duration;
        this.score = score;
        this.location = location;
        this.winner = this.getMatchWinner();
    }


    public void showMatchInfos(){
        System.out.print("\nWelcome to the match beteen " + teams.get(0).name + " vs " + teams.get(1).name);
        System.out.print("\nThe game is played at " + location);
        System.out.print("\nThe first score is " + getReadableFinalScore());
        System.out.print("\nThe match duration was " + duration);
    }

    private FootBallTeam getMatchWinner() {
        if(score.get(teams.get(0)) > score.get(teams.get(1))){
            return teams.get(0);
        }
        else if(score.get(teams.get(0)) < score.get(teams.get(1))){
            return teams.get(1);
        }
        else {
            return null;
        }
    }

    public String getReadableFinalScore(){
        return teams.get(0).name + " " + score.get(teams.get(0)) + " - " 
        + score.get(teams.get(1)) + " " + teams.get(0).name;
    }

    
}
