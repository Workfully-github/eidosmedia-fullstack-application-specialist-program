package Football;

import java.util.ArrayList;
import Football.FootballTeam;
import Football.FootballMatch;
public class PremierLeague {


    /*

    Premier League is a league with 4 teams,
    every team should play one match against all the partecipants:
     - Every win is 3 points
     - Every draw is 1 point
     - Every defait is 0 points 

    Total matches is: 6  
    */

    public static void main(String[] args) {



        League premierLeague = new League("Premier League 2022-2023", getPremierLeagueTeams());
        premierLeague.setMatches(getMatchesCalendar());

        premierLeague.playMatches();

        HashMap<FootballTeam, Integer> standings  = premierLeague.getStandings();
        
        premierLeague.getTopScorers();
        //Hello
        
        FootballTeam arsenal = new FootballTeam();
        
        arsenal.getTopScorers();
        // Bye
        
    

        // print the standings
        






        
    }


    private static ArrayList<FootballTeam> getPremierLeagueTeams(){

        //TODO generate teams and return the arraylist

        return new ArrayList<FootballTeam>();
    }

    private static ArrayList<FootballMatch> getMatchesCalendar(){
        //TODO generate matches and return the arraylist

        return new ArrayList<FootballMatch>();
    }

}