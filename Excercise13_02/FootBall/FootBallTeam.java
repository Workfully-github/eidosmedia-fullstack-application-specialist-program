package Excercise13_02.FootBall;

import java.util.ArrayList;

import Excercise13_02.Player;

public class FootBallTeam {
    protected ArrayList<Player> teamPlayers;
    protected String name;

    public FootBallTeam(ArrayList<Player> teamPlayers, String name) {
        this.teamPlayers = teamPlayers;
        this.name = name;
    }

    @Override
    public String toString() {
        return "FootBallTeam [teamPlayers=" + teamPlayers + ", name=" + name + "]";
    }

    
    
}
