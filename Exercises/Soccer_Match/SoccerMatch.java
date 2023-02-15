package Soccer_Match;

import java.util.ArrayList;
import java.util.HashMap;

public class SoccerMatch {
    
    private ArrayList<SoccerTeam> teams;
    private static final int DURATION = 90;
    private String location;
    private String referee;
    private HashMap<SoccerTeam, Integer> result = new HashMap<SoccerTeam, Integer>();

    private ArrayList<SoccerGoal> goals = new ArrayList<SoccerGoal>();

    public SoccerMatch(ArrayList<SoccerTeam> teams, String location, String referee) {
        this.teams = teams;
        this.location = location;
        this.referee = referee;

        result.put(teams.get(0),0);
        result.put(teams.get(1),0);
    }

    public ArrayList<SoccerTeam> getTeams() {
        return teams;
    }

    public void scoreAGoal(SoccerGoal goal) {
        goals.add(goal);

        int previousResult = result.get(goal.getTeam());
        int newScore = previousResult ++;
        result.put(goal.getTeam(), newScore);
    }

    public HashMap<SoccerTeam, Integer> getResult() {
        return result;
    }

    public boolean isADraw() {
        if (result.get(0) == result.get(1)) {
            return true;
        } else {
            return false;
        }
    }

    public SoccerTeam getWinner() {
        int winnerIndex = 0;
        if (result.get(0) < result.get(1)) winnerIndex = 1;
        return teams.get(winnerIndex);
    }
}
