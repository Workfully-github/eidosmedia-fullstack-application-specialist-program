package Soccer_Match;

import java.util.ArrayList;
import java.util.HashMap;

public class SoccerLeague {
    
    private String name;
    private ArrayList<SoccerTeam> teams;
    private ArrayList<SoccerMatch> matches;
    private HashMap<SoccerTeam, Integer> points;
    private HashMap<SoccerTeam, Integer> wins;
    private HashMap<SoccerTeam, Integer> losses;
    private HashMap<SoccerTeam, Integer> draws;
    private HashMap<SoccerTeam, Integer> goalsScored;
    private HashMap<SoccerTeam, Integer> goalsSuffered;

    public SoccerLeague(String name, ArrayList<SoccerTeam> teams, ArrayList<SoccerMatch> matches,
    HashMap<SoccerTeam, Integer> points, HashMap<SoccerTeam, Integer> wins, HashMap<SoccerTeam,
    Integer> losses, HashMap<SoccerTeam, Integer> draws, HashMap<SoccerTeam, Integer> goalsScored,
    HashMap<SoccerTeam, Integer> goalsSuffered) {
        this.name = name;
        this.teams = teams;
        this.matches = matches;
        this.points = points;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        this.goalsScored = goalsScored;
        this.goalsSuffered = goalsSuffered;
    }

    public HashMap<SoccerTeam, Integer> getPoints() {
        return points;
    }

    public HashMap<SoccerTeam, Integer> getWins() {
        return wins;
    }

    public HashMap<SoccerTeam, Integer> getLosses() {
        return losses;
    }

    public HashMap<SoccerTeam, Integer> getDraws() {
        return draws;
    }

    public HashMap<SoccerTeam, Integer> getGoalsScored() {
        return goalsScored;
    }

    public HashMap<SoccerTeam, Integer> getGoalsSuffered() {
        return goalsSuffered;
    }
}
