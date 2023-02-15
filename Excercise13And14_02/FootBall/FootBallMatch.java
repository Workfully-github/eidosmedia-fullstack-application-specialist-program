package Excercise13And14_02.FootBall;

import java.util.ArrayList;
import java.util.HashMap;

import Excercise13And14_02.Player;

public class FootBallMatch {
    private ArrayList<FootBallTeam> teams = new ArrayList<>();
    private int duration;
    private HashMap<FootBallTeam, Integer> result = new HashMap<FootBallTeam,Integer>();
    private String location;
    private ArrayList<Goal> goals = new ArrayList<>();
    private FootBallTeam winner ;
    private Player mOfTheMatch;

    public FootBallMatch(ArrayList<FootBallTeam> teams, int duration, HashMap<FootBallTeam, Integer> result,
            String location) {
        this.teams = teams;
        this.duration = duration;
        this.result = result;
        this.location = location;
    }

    public Player getManOfMatch() {
        return null;
    }


    public void showMatchInfos(){
        System.out.print("\nWelcome to the match beteen " + teams.get(0).name + " vs " + teams.get(1).name);
        System.out.print("\nThe game is played at " + location);
        System.out.print("\nThe first scofre is " + getReadableFinalScore());
        System.out.print("\nThe match duration was " + duration);
    }

    public FootBallTeam updateMatchWinner() {
        if(result.get(teams.get(0)) > result.get(teams.get(1))){
            return teams.get(0);
        }
        else if(result.get(teams.get(0)) < result.get(teams.get(1))){
            return teams.get(1);
        }
        else {
            return null;
        }
    }

    public String getReadableFinalScore(){
        return teams.get(0).name + " " + result.get(teams.get(0)) + " - " 
        + result.get(teams.get(1)) + " " + teams.get(1).name;
    }

    public void scoredAGoal(Goal goal1) {
        this.goals.add(goal1);
        if(teams.get(0).teamPlayers.contains(goal1.scorer)){
            result.put(teams.get(0), result.get(teams.get(0)) + 1); 
        }
        else{
            result.put(teams.get(1), result.get(teams.get(1)) + 1);
        }
    }

    public HashMap<FootBallTeam, Integer> getResult() {
        return result;
    }

    
}
