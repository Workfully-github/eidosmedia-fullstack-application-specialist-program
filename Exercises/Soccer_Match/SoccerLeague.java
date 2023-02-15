package Soccer_Match;

import java.util.ArrayList;
import java.util.HashMap;

public class SoccerLeague {
    
    private String name;
    private ArrayList<SoccerTeam> teams;
    private ArrayList<SoccerMatch> matches;
    private HashMap<SoccerTeam, Integer> standings = new HashMap<SoccerTeam,Integer>();
    /* private HashMap<SoccerTeam, Integer> wins;
    private HashMap<SoccerTeam, Integer> losses;
    private HashMap<SoccerTeam, Integer> draws;
    private HashMap<SoccerTeam, Integer> goalsScored;
    private HashMap<SoccerTeam, Integer> goalsSuffered; */

    private static int POINTS_WIN = 3;
    private static int POINTS_DRAW = 1;
    private static int POINTS_DEFEAT = 0;

    public SoccerLeague(String name, ArrayList<SoccerTeam> teams, ArrayList<SoccerMatch> matches,
    HashMap<SoccerTeam, Integer> standings)
    /*  HashMap<SoccerTeam, Integer> wins, HashMap<SoccerTeam,
    Integer> losses, HashMap<SoccerTeam, Integer> draws, HashMap<SoccerTeam, Integer> goalsScored,
    HashMap<SoccerTeam, Integer> goalsSuffered) */ {
        this.name = name;
        this.teams = teams;
        generateStandings();
        /* this.matches = matches;
        this.standings = standings;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        this.goalsScored = goalsScored;
        this.goalsSuffered = goalsSuffered; */
    }

    public void setMatches(ArrayList<SoccerMatch> matches) {
        this.matches = matches;
    }

    public void playMatches() {
        // generate result of all league matches
        // assignPoints(match);
    }

    private void assignPoints(SoccerMatch match){
        HashMap<SoccerTeam,Integer> result = match.getResult();
        
        if(match.isADraw()){
            int previousPoints = standings.get(result.get(0));
            int newPoints = previousPoints += POINTS_DRAW;
            standings.put(result.get(0), newPoints);
            standings.put(result.get(1), newPoints);
        }

        //assign points to the winner        
        SoccerTeam winner = match.getWinner();

        int previousPoints = standings.get(winner);
        int newPoints = previousPoints += POINTS_WIN;
        standings.put(winner, newPoints);





        // assign points to the teams based on match result 
    }

    private void generateStandings(){
        //TODO update the hashmap based on the teams
        // use alphabetical sorting

    }

    /**
     * @return the standings
     */
    public HashMap<FootballTeam, Integer> getStandings() {

        //TODO sort the standings based on value
        return standings;
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
