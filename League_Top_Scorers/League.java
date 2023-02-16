// package Football;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class League {

    private String name;
    private Map<FootballPlayer, Integer> scorers;
    private ArrayList<FootballTeam> teams;
    private ArrayList<FootballMatch> matches;
    private HashMap<FootballTeam,Integer> standings = new HashMap<FootballTeam,Integer>();

    private static int POINTS_WIN = 3;
    private static int POINTS_DRAW = 1;
    private static int POINTS_DEFAIT = 0;


    


    public League(String name,ArrayList<FootballTeam> teams){
        this.name = name;
        this.teams = teams;
        generateStandings();
        generateScorers();
    }



    /**
     * @param matches the matches to set
     */
    public void setMatches(ArrayList<FootballMatch> matches) {
        this.matches = matches;
    }


    public void playMatches(){
        // generate result of all league matches
        // assignPoints(match);
    }

    private void assignPoints(FootballMatch match){
        HashMap<FootballTeam,Integer> result = match.getResult();
    

        if(result.isADraw())
                // one point for each team
                return;

        //assign points to the winner        
        result.getWinner();


       // result.getLoser()





        // assign points to the teams based on match result 
    }

    private void generateStandings(){
        //TODO update the hashmap based on the teams
        // use alphabetical sorting

    }

    /**
     * @return the standings
     */
    public HashMap<FootballTeam, Integer> getStandings() {

        //TODO sort the standings based on value
        return standings;
    }


    public void generateScorers() {
        //TODO Update the Players Map based on the Players
    }

    public ArrayList<FootballPlayer> getTopScorers() {

        Map<FootballPlayer,Integer>  sortedTopScorers =  scorers.entrySet()
        .stream()
        .sorted(Map.Entry.comparingByValue())
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        return new ArrayList<FootballPlayer>(sortedTopScorers.keySet());
    }

    
    int previousPlayerScore = 0;
    public void setScorers(FootballPlayer scorer) {
        //check if the player already exist, to get his previous score
        if(scorers.containsKey(scorer)) previousPlayerScore = scorers.get(scorer);
        scorers.put(scorer, previousPlayerScore++);
    }

  

}