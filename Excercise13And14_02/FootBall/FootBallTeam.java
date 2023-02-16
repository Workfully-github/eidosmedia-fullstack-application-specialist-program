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

    public ArrayList<Player> getBestPlayerByPerf(){
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

    public ArrayList<Player> getBestPlayerByGoals(){
        if(this.teamPlayers.size()==0){
            return null;
        }

        int currentValue = this.teamPlayers.get(0).getNumberGoals();
        ArrayList<Player> bestPlayers = new ArrayList<>();

        int flag = 0;
        for(int i=0; i<this.teamPlayers.size(); i++){
            flag = 0;
            for(int k=0; k<bestPlayers.size(); k++){
                if(currentValue > bestPlayers.get(k).getNumberGoals() ){
                    currentValue = this.teamPlayers.get(i).getNumberGoals();
                    bestPlayers.add(k, this.teamPlayers.get(i));
                    flag = 1;
                    k = bestPlayers.size();
                }
            }
            if(flag==0){
                bestPlayers.add(this.teamPlayers.get(i));
            }
            
        }
        return bestPlayers;
    }

    public ArrayList<Player> getTeamPlayers() {
        return teamPlayers;
    }


    public void showBestPlayerBy(String refBy){
        System.out.print(this.name + " team :Best player by " + refBy + "\n");
        if(refBy=="gaol"){
            ArrayList<Player> sortedPlayers = this.getBestPlayerByGoals();
            for(int i=0; i<sortedPlayers.size();i++){
                System.out.print(i+1 + "-) " + sortedPlayers.get(i).toString());
            }
        }
        ArrayList<Player> sortedPlayers = this.getBestPlayerByGoals();
        for(int i=0; i<sortedPlayers.size();i++){
            System.out.print(i+1 + "-) " + sortedPlayers.get(i).toString());
        }
    }

    
    
}
