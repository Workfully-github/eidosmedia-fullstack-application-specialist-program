package Sport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import Sport.Championships.League;
import Sport.Championships.LeagueType;
import Sport.Championships.NationalLeague;
import Sport.Teams.Teams;
import Sport.Teams.Players.AbstractPlayer;
import Sport.Teams.Players.FootballPlayer;

public class Bootstrap {

    public League bootstrapInit(){
       return bootstrapNewLeagueWithInput();
    }

    private ArrayList<Teams> bootstrapTeamsWithInput(){
        
        Scanner scNumberOfTeamsInLeague = new Scanner(System.in);
        System.out.println("How many teams will play in this league?");

        int numberOfSelectedTeams = scNumberOfTeamsInLeague.nextInt();

        ArrayList<Teams> teamList = new ArrayList<>();

        for (int i = 1; i <= numberOfSelectedTeams; i++) {
            System.out.print(i + " - Insert Name: ");
            Scanner scTeamName = new Scanner(System.in);

            teamList.add(new Teams(
                scTeamName.next(), 
                new ArrayList<AbstractPlayer>()
                {
                    {
                        for (int j = 1; j <= 11; j++) {
                            add(new FootballPlayer("Stub_" + j));
                        }
                    }
                }));
        }        

        return teamList;
    }
    
    private League bootstrapNewLeagueWithInput(){
        
        int leagueTypeCounter = 0;
        System.out.println("What League do you want to play?");
        Scanner scLeagueSelection = new Scanner(System.in);

        for (LeagueType leagueType : LeagueType.values()) {
            leagueTypeCounter++;
            System.out.println(leagueTypeCounter + " - " + LeagueType.NATIONALLEAGUE.getLeagueType());
        }

        switch (scLeagueSelection.nextInt()) {
            case 1:
                return new NationalLeague(bootstrapTeamsWithInput());
        
            default:
                System.out.println("Empty League Instantiated");
                break;
        }

        return new NationalLeague();
    }
}
