package Soccer_Match;

import java.util.ArrayList;

public class SoccerTeam {
    
    private String name;
    private ArrayList<SoccerPlayer> players;
    private String coach;
    private String city;
    /* win, draw, loss, goalsScored, goalsConceded in here or in the league class?*/

    public SoccerTeam(String name, ArrayList<SoccerPlayer> players, String coach, String city) {
        this.name = name;
        this.players = players;
        this.coach = coach;
        this.city = city;
    }

    public String getTeamName() {
        return name;
    }

    public ArrayList<SoccerPlayer> getPlayers() {
        return players;
    }
    
    public String getCoach() {
        return coach;
    }

    public String getCity() {
        return city;
    }
}
