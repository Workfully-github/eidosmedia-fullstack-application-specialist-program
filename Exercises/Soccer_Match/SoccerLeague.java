package Soccer_Match;

import java.util.ArrayList;
import java.util.HashMap;

public class SoccerLeague {
    
    private String name;
    private ArrayList<SoccerTeam> teams;
    private ArrayList<SoccerMatch> matches;
    private HashMap<SoccerTeam, Integer> standings = new HashMap<SoccerTeam,Integer>();

    private static int POINTS_WIN = 3;
    private static int POINTS_DRAW = 1;
    private static int MAX_NUMBER_GOALS = 5;

    public SoccerLeague(String name, ArrayList<SoccerTeam> teams/* , ArrayList<SoccerMatch> matches,
    HashMap<SoccerTeam, Integer> standings */) {
        this.name = name;
        this.teams = teams;
        generateStandings();
    }

    public void setMatches(ArrayList<SoccerMatch> matches) {
        this.matches = matches;
    }

    public void playMatches() {
        // Generate a random number of goals and add it to the match
        for(int i = 0; i < matches.size(); i++) {
            // Number of goals in a game
            int numGoals = (int) Math.floor((Math.random() * MAX_NUMBER_GOALS) + 1);
            int goalsHomeTeam = (int) Math.floor((Math.random() * numGoals));
            int goalsAwayTeam = numGoals- goalsHomeTeam;
            
            HashMap<SoccerTeam,Integer> result = matches.get(i).getResult();

            result.put(matches.get(i).getTeams().get(0), goalsHomeTeam);
            result.put(matches.get(i).getTeams().get(1), goalsAwayTeam);

            assignPoints(matches.get(i));
        }
    }

    private void assignPoints(SoccerMatch match){
        HashMap<SoccerTeam,Integer> result = match.getResult();
        // Assign points when it's a draw
        if(match.isADraw()){
            int previousPoints = standings.get(result.get(0));
            int newPoints = previousPoints += POINTS_DRAW;
            standings.put(match.getTeams().get(0), newPoints);
            standings.put(match.getTeams().get(1), newPoints);
        }

        // Assign points to the winner        
        SoccerTeam winner = match.getWinner();

        int previousPoints = standings.get(winner);
        int newPoints = previousPoints += POINTS_WIN;
        standings.put(winner, newPoints);
    }

    private void generateStandings(){
        // use alphabetical sorting

        for (int i = 0; i < teams.size(); i++) {
            standings.put(teams.get(i), 0);
        }
    }

    public HashMap<SoccerTeam, Integer> getStandings() {

        //TODO sort the standings based on value
        // see https://www.geeksforgeeks.org/sorting-a-hashmap-according-to-values/
        return standings;
    }

    public void assignGoals() {
        // check who scored and create and create an HashMap<SoccerPlayer, Integer>
    }
}
