// package Football;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;



public class FootballTeam {
    
    
    private String name;
    private ArrayList<FootballPlayer> players;
    private Map<FootballPlayer, Integer> scorers;
    private String coach;


    /**
     * @return the players
     */
    public ArrayList<FootballPlayer> getPlayers() {
        return players;
    }

    

    // Sorting the team scorers table
    public ArrayList<FootballPlayer> getTeamTopScorers() {

        Map<FootballPlayer,Integer>  sortedTopScorers =  scorers.entrySet()
        .stream()
        .sorted(Map.Entry.comparingByValue())
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        // Return an array list of the sorted players
        return new ArrayList<FootballPlayer>(sortedTopScorers.keySet());

    }

    // Update the team scorers table
    int previousPlayerScore = 0;
    public void setScorers(FootballPlayer scorer) {
        //check if the player already exist, to get his previous score
        if(scorers.containsKey(scorer)) previousPlayerScore = scorers.get(scorer);
        scorers.put(scorer, previousPlayerScore++);
    }

}