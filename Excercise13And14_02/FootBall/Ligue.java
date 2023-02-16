package Excercise13And14_02.FootBall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import Excercise13And14_02.Player;

public class Ligue {
    private ArrayList<FootBallTeam> teams = new ArrayList<>();
    private ArrayList<Goal> goals = new ArrayList<>();
    private ArrayList<FootBallMatch> matchs = new ArrayList<>();
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

    public void addGoal(Goal goal){
        this.goals.add(goal);
    }

    public void addMatch(FootBallMatch match){
        this.matchs.add(match);
        //assign the points if the match is finish
        this.assignPoint(match);
    }

    private void updatePointForByTeam(FootBallTeam team, Integer numberOfPoint){
        int previewsPoint = statisticsTeams.get(team).getPoints();
        statisticsTeams.get(team).setPoints(previewsPoint + numberOfPoint);
    }

    private void assignPoint(FootBallMatch match){
        HashMap<FootBallTeam, Integer> result = match.getResult();

        FootBallTeam team1 = new FootBallTeam(null, endDate);
        FootBallTeam team2 = new FootBallTeam(null, endDate);
        int goalTeam1 = 0;
        int goalTeam2 = 0;
        int iterator = 0;
        for( Map.Entry<FootBallTeam, Integer> entry : result.entrySet()){
            if(iterator==0){
                team1 = entry.getKey();
                goalTeam1 = entry.getValue();
                iterator++;
            }
            else{
                team2 = entry.getKey();
                goalTeam2 = entry.getValue();
                iterator++;
            }
        }
        int numPoint1 = 0;
        int numPoint2 = 0;
        if(goalTeam1 == goalTeam2){
            numPoint1 = 1;
            numPoint2 = 1;
        }
        else if(goalTeam1 > goalTeam2){
            numPoint1 = 3;
            numPoint2 = 0;
        }
        else{
            numPoint1 = 0;
            numPoint2 = 3;
        }
        updatePointForByTeam(team1, numPoint1);
        updatePointForByTeam(team2, numPoint2);
    }

    public void showStanding(){
        ArrayList<FootBallTeam> sortedTeams = this.sortTeamByPoint();
        System.out.println("\n\nHere is the standing of the championat : \n");
        for(int i=sortedTeams.size()-1; i>=0; i--){
            System.out.println(sortedTeams.get(i).name + " ==> " + statisticsTeams.get(sortedTeams.get(i)).toString() );
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

    public void showScorePlayer(){
        HashMap<Player,Integer> playerWithGoals = bestPlayerByPerf();
        System.out.println("Scores for players :");
        for(Map.Entry<Player, Integer> entry : playerWithGoals.entrySet()){
            System.out.println(entry.getKey().toString() + " ==> " + entry.getValue() + " goals\n");
        }
    }

    public HashMap<Player, Integer> bestPlayerByPerf(){
        HashMap<Player, Integer> PlayerByNumberOfGoal = new LinkedHashMap<Player,Integer>();
        for (int i=0; i < this.goals.size(); i++){
            if(!PlayerByNumberOfGoal.containsKey(this.goals.get(i).scorer)){
                PlayerByNumberOfGoal.put(this.goals.get(i).scorer, 1);
            }
            else{
                PlayerByNumberOfGoal.put(this.goals.get(i).scorer, PlayerByNumberOfGoal.get(this.goals.get(i).scorer) + 1);
            }
        }
        HashMap<Player, Integer> sortPlayerByNumberOfGoal = new LinkedHashMap<Player,Integer>();
        ArrayList<Player> playerSortedList = new ArrayList<>();
        int currentPoint;
        int flag;
        for(Map.Entry<Player, Integer> entry : PlayerByNumberOfGoal.entrySet()){
            currentPoint = entry.getValue();
            flag = 0;
            for(int k=0; k < playerSortedList.size(); k++){
                if(currentPoint > PlayerByNumberOfGoal.get(playerSortedList.get(k))){
                    playerSortedList.add(k,entry.getKey());
                    flag = 1;
                    k = playerSortedList.size(); 
                }
            }
            if(flag==0){
                playerSortedList.add(entry.getKey()) ;
            }
        }
        for(int i=0;i<playerSortedList.size();i++){
            sortPlayerByNumberOfGoal.put(playerSortedList.get(i), PlayerByNumberOfGoal.get(playerSortedList.get(i)));
        }
        return sortPlayerByNumberOfGoal;
    }

}
