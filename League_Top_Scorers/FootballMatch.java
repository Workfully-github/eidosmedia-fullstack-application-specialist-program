// package Football;

import java.util.ArrayList;
import java.util.HashMap;

public class FootballMatch {

    private static final int DURATION = 90;

    private ArrayList<FootballTeam> teams; 
    private String location;
    private String referee;
    private HashMap<FootballTeam, Integer> result = new HashMap<FootballTeam,Integer>();

    private ArrayList<Goal> goals = new ArrayList<Goal>();

    public FootballMatch(ArrayList<FootballTeam> teams, String location,String referee){
        this.teams = teams;
        this.location = location;
        this.referee = referee;
        
        // initialize result
        result.put(teams.get(0),0);
        result.put(teams.get(1),0);


    }


    public void scoreAGoal(Goal goal){
        goals.add(goal);
        int previuousResult = result.get(goal.getTeam());
        int newResult = previuousResult++;
        result.put(goal.getTeam(), newResult );
        
        // 1- Update the scorers table for the league
        goal.getLeague().setScorers(goal.getScorer());
        
    // 2- Update the scorers table for the team
        goal.getTeam().setScorers(goal.getScorer());

    }


    public HashMap<FootballTeam,Integer> getResult(){
        //TODO
        return result;

    }












}