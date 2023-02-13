package Sport.Sports;

import java.util.ArrayList;
import java.util.HashMap;

import Sport.Teams.Teams;

public class FootballMatch extends AbstractSports {

    public final String MATCHTYPE = "Football";

    /* Constructor */
    public FootballMatch(
        ArrayList<Teams> teams, 
        HashMap<Teams, Integer> scoreMap, 
        int duration, 
        String location
        ){
        
        this.scoreMap = scoreMap;
        this.duration = duration;
        this.location = location;
        this.teams = teams;
    }






    // Create a readable string from an hashmap describing tenismatch scoreMap (make a method)
    
}
