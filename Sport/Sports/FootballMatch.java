package Sport.Sports;

import java.util.ArrayList;
import java.util.HashMap;

import Sport.Scores.Goal;
import Sport.Scores.Score;
import Sport.Teams.Teams;
import Sport.Teams.Players.FootballPlayer;

public class FootballMatch extends AbstractSports {

    public final String MATCHTYPE = "Football";

    /* CONSTRUCTOR ONE */

    public FootballMatch(
            ArrayList<Teams> teamList
            ) {

        this.teamList = teamList;
        
        
        populateScoreHashMap(teamList.get(0), teamList.get(1));

        findResult();

        //System.out.println("Here: " + getScoreMap().get(teamList.get(0)));
        //System.out.println("Here: " + getScoreMap().get(teamList.get(1)));

    }

    /* CONSTRUCTOR TWO */
    public FootballMatch(
            ArrayList<Teams> teamList,
            HashMap<Teams, ArrayList<Score>> scoreMap,
            int duration,
            String location) {

        this.scoreMap = scoreMap;
        this.duration = duration;
        this.location = location;
        this.teamList = teamList;
    }

    /* METHODS */

    /* GENERATES A FOOTBALL MATCH BETWEEN TWO TEAMS
     * GOALS ARE CALCULATED RANDOMLY USING PROBABILITIES
     * 60% of a team not scoring any goals
     * 10% chance of scoring more than one goal
     * 30% of scoring one goal
     * Scorer will be selected randomly from team rooster
     */
    public void populateScoreHashMap(Teams homeTeam, Teams awayTeam) {
        scoreMap = new HashMap<>() {
            {
                put(homeTeam, generateRandomScore(homeTeam));
                put(awayTeam, generateRandomScore(awayTeam));
            }
        };
    }

    private int randomMinuteFromOnetoNinety(){
        return (int) Math.floor((Math.random() * 90) + 1);
    }

    private FootballPlayer randomPlayer(Teams team){
        return (FootballPlayer)teamList.get(0).getListOfPlayers().get((int) Math.floor((Math.random() * 10) + 0));
    }

    private FootballPlayer randomAssistantChance(Teams team){

        if((int) Math.floor((Math.random() * 100) + 0) > 10 ){
           return (FootballPlayer) team.getListOfPlayers().get((int) Math.floor((Math.random() * 10) + 0));
        }
        return null;
    }

    public ArrayList<Score> generateRandomScore(Teams team){

        ArrayList<Score> arrayList = new ArrayList<Score>() {
            {
                int randomGoalChance = (int) Math.floor((Math.random() * 10) + 0);
                
                if(randomGoalChance > 7){
                    for(int i = 0; i < (int) Math.floor((Math.random() * 5) + 1); i++){                
                        add(new Goal(randomPlayer(team), randomAssistantChance(team) ,randomMinuteFromOnetoNinety()));
                    }
                }

                if(randomGoalChance > 2 && randomGoalChance <= 7){
                        add(new Goal(randomPlayer(team), randomAssistantChance(team) ,randomMinuteFromOnetoNinety()));
                }          
            }
        };

        return arrayList;
    }

    private void findResult(){

        Teams homeTeam = teamList.get(0);
        Teams awayTeam = teamList.get(1);

        if(scoreMap.get(homeTeam).size() > scoreMap.get(awayTeam).size()){
            
            setWinner(homeTeam);
            setLoser(awayTeam);
            //System.out.println("There was a winner. " + getWinner().getName());
        };

        if(scoreMap.get(homeTeam).size() < scoreMap.get(awayTeam).size()){
            
            setWinner(awayTeam);
            setLoser(homeTeam);
            //System.out.println("There was a loser " + getLoser().getName());
        };

        if(scoreMap.get(homeTeam).size() == scoreMap.get(awayTeam).size()){
            //System.out.println("There was a stalemate between " + homeTeam.getName() + " " + awayTeam.getName());
            setStalemate(true);
        };
    }



}
