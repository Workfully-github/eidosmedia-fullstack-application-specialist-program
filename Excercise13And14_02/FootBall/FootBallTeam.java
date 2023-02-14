package Excercise13And14_02.FootBall;

import java.util.ArrayList;

import Excercise13And14_02.Player;

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

    public ArrayList<Player> getBestPlayer(){
        int perfmax = this.teamPlayers.get(0).getPerf();
        ArrayList<Player> bestPlayers = new ArrayList<>();

        for(int i=1; i<this.teamPlayers.size(); i++){
            if(perfmax < this.teamPlayers.get(i).getPerf() ){
                perfmax = this.teamPlayers.get(i).getPerf();
            }
            bestPlayers.add(this.teamPlayers.get(i));
        }
        return bestPlayers;
    }

    public ArrayList<Player> getTeamPlayers() {
        return teamPlayers;
    }
    

    
    
}
