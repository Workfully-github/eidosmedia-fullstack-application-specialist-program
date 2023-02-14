package Excercise13And14_02.FootBall;

import java.util.ArrayList;
import java.util.HashMap;

public class Ligue {
    private ArrayList<FootBallTeam> teams = new ArrayList<>();
    private String startDate;
    private String endDate;
    private HashMap<FootBallTeam, TeamPerformence> statisticsTeams = new HashMap<FootBallTeam,TeamPerformence>();

    public Ligue(ArrayList<FootBallTeam> teams, String startDate, String endDate) {
        this.teams = teams;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void addTeamAndStat(FootBallTeam team, TeamPerformence teamPerf){
        this.statisticsTeams.put(team, teamPerf);
        if(!this.teams.contains(team)){
            this.teams.add(team);
        }
    }


    public void showStanding(){
        ArrayList<FootBallTeam> sortedTeams = this.sortTeamByPoint();
        System.out.println("\n\nHere is the standing of the championat : \n");
        for(int i=sortedTeams.size()-1; i>=0; i--){
            System.out.println(sortedTeams.get(i).name + "==>" + statisticsTeams.get(sortedTeams.get(i)).toString() );
        }
    }

    private ArrayList<FootBallTeam> sortTeamByPoint(){

        ArrayList<FootBallTeam> sortedTeams = new ArrayList<>();
        if(this.teams.size()==0){
            return sortedTeams;
        }

        int currentPoint;
        int flag;
        for(int i=0; i<this.teams.size(); i++){
            currentPoint = this.statisticsTeams.get(teams.get(i)).getPoints();
            flag = 0;
            for(int k=0; k < sortedTeams.size(); k++){
                if(currentPoint < this.statisticsTeams.get(sortedTeams.get(k)).getPoints()){
                    sortedTeams.add(k, teams.get(i));
                    flag = 1;
                    k = sortedTeams.size(); 
                }
            }

            if(sortedTeams.size()==0){
                sortedTeams.add(teams.get(i));
            }

            else if(flag == 0){
                sortedTeams.add(teams.get(i));
            }
        }

        return sortedTeams;
    }

    

}
