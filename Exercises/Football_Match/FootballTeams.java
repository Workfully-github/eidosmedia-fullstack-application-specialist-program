package Football_Match;

import java.util.ArrayList;

public class FootballTeams {
    public ArrayList<FootballPlayers> players = new ArrayList();
    /* public ArrayList<FootballPlayers> scorers = new ArrayList(); */
    public String name, city;
    public int wins, position, goalsScored, goalsConceded;

    public FootballTeams(ArrayList<FootballPlayers> players, //ArrayList<FootballPlayers> scorers, 
    String name, String city, int wins, int position, int goalsScored, int goalsConceded) {
        this.players = players;
        this.name = name;
        this.city = city;
        this.wins = wins;
        this.position = position;
        this.goalsScored = goalsScored;
        this.goalsConceded = goalsConceded;
        //this.scorers = scorers;
    }
}
