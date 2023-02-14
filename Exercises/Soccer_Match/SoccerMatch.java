package Soccer_Match;

import java.util.ArrayList;

public class SoccerMatch {
    
    private ArrayList<SoccerTeam> teams;
    private static final int DURATION = 90;
    private String location;
    private String referee;

    private ArrayList<SoccerGoal> goals = new ArrayList<SoccerGoal>();

    public SoccerMatch(ArrayList<SoccerTeam> teams, String location, String referee) {
        this.teams = teams;
        this.location = location;
        this.referee = referee;
    }

    public ArrayList<SoccerTeam> getTeams() {
        return teams;
    }

    public String getLocation() {
        return location;
    }

    public String getReferee() {
        return referee;
    }
    
    public int getDuration() {
        return DURATION;
    }

    public void scoreAGoal(SoccerGoal goal) {
        goals.add(goal);
    }
}
