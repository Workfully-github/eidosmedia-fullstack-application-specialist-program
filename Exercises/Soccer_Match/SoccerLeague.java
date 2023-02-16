package Soccer_Match;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Comparator;

public class SoccerLeague {
    
    private String name;
    private ArrayList<SoccerTeam> teams;
    private ArrayList<SoccerMatch> matches;
    private HashMap<SoccerTeam, Integer> standings = new HashMap<SoccerTeam,Integer>();
    private HashMap<SoccerPlayer, Integer> scorers = new HashMap<SoccerPlayer,Integer>();

    private static int POINTS_WIN = 3;
    private static int POINTS_DRAW = 1;
    

    public SoccerLeague(String name, ArrayList<SoccerTeam> teams) {
        this.name = name;
        this.teams = teams;
        generateStandings();
    }

    public void setMatches(ArrayList<SoccerMatch> matches) {
        this.matches = matches;
    }

    public void playMatches() {
        int MAX_NUMBER_GOALS = 5;
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
        ArrayList<HashMap.Entry<SoccerTeam, Integer> > list =
               new ArrayList<HashMap.Entry<SoccerTeam, Integer> >(standings.entrySet());

        Collections.sort(list, new Comparator<HashMap.Entry<SoccerTeam, Integer> >() {
            public int compare(HashMap.Entry<SoccerTeam, Integer> o1,
            HashMap.Entry<SoccerTeam, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        
        HashMap<SoccerTeam, Integer> temp = new LinkedHashMap<SoccerTeam, Integer>();
        for (HashMap.Entry<SoccerTeam, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }

        return temp;
    }

    private void assignGoals(SoccerMatch match) {
        HashMap<SoccerTeam,Integer> result = match.getResult();
        int numGoalsHomeTeam = result.get(0);
        int numGoalsAwayTeam = result.get(1);

        // Assign goals to home team
        for (int i = 0; i < numGoalsHomeTeam; i++) {
            int playerIndex = (int) Math.floor((Math.random() * 11));
            int assistantIndex = (int) Math.floor((Math.random() * 11));
            int minuteGoal = (int) Math.floor((Math.random() * 90) + 1);

            SoccerGoal goal = new SoccerGoal(teams.get(0).getPlayers().get(playerIndex), minuteGoal, teams.get(0).getPlayers().get(assistantIndex), teams.get(0));
            match.scoreAGoal(goal);
            scorers.put(teams.get(0).getPlayers().get(playerIndex), 1);
            // update player Top scorers
            teams.get(0).setTeamScorers(teams.get(0).getPlayers().get(playerIndex));
        }

        // Assign goals to away team
        for (int i = 0; i < numGoalsAwayTeam; i++) {
            int playerIndex = (int) Math.floor((Math.random() * 11));
            int assistantIndex = (int) Math.floor((Math.random() * 11));
            int minuteGoal = (int) Math.floor((Math.random() * 90) + 1);
            
            SoccerGoal goal = new SoccerGoal(teams.get(1).getPlayers().get(playerIndex), minuteGoal, teams.get(1).getPlayers().get(assistantIndex), teams.get(1));
            match.scoreAGoal(goal);
            scorers.put(teams.get(1).getPlayers().get(playerIndex), 1);
            // update player Top scorers
            teams.get(1).setTeamScorers(teams.get(1).getPlayers().get(playerIndex));
        }
    }

    private void assignGoal() {

    }

    public HashMap<SoccerPlayer, Integer> getTopScorer() {
        ArrayList<HashMap.Entry<SoccerPlayer, Integer> > list =
               new ArrayList<HashMap.Entry<SoccerPlayer, Integer> >(scorers.entrySet());

        Collections.sort(list, new Comparator<HashMap.Entry<SoccerPlayer, Integer> >() {
            public int compare(HashMap.Entry<SoccerPlayer, Integer> o1,
            HashMap.Entry<SoccerPlayer, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        
        HashMap<SoccerPlayer, Integer> temp = new LinkedHashMap<SoccerPlayer, Integer>();
        for (HashMap.Entry<SoccerPlayer, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }

        return temp;
    }
}
