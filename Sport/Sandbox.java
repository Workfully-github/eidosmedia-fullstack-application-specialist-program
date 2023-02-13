package Sport;

import java.util.ArrayList;
import java.util.HashMap;

import Sport.Sports.FootballMatch;
import Sport.Teams.Teams;
import Sport.Teams.Players.AbstractPlayer;
import Sport.Teams.Players.FootballPlayer;

public class Sandbox {

    public static void main(String[] args) {

        /* TIP: COLLAPSE ALL METHODS FOR BETTER VIEW */

        // TEAM A
        ArrayList<AbstractPlayer> footballPlayerListA = new ArrayList<>() {
            {
                add(new FootballPlayer("Ricardo"));
                add(new FootballPlayer("Hugo"));
                add(new FootballPlayer("Diogo"));
                add(new FootballPlayer("João"));
                add(new FootballPlayer("Luís"));
                add(new FootballPlayer("Artur"));
                add(new FootballPlayer("Alexandre"));
                add(new FootballPlayer("Nuno"));
                add(new FootballPlayer("Salgado"));
                add(new FootballPlayer("Amine"));
                add(new FootballPlayer("Abdu"));

            }
        };
        // TEAM B
        ArrayList<AbstractPlayer> footballPlayerListB = new ArrayList<>() {
            {
                add(new FootballPlayer("Test1"));
                add(new FootballPlayer("Test2"));
                add(new FootballPlayer("Test3"));
                add(new FootballPlayer("Test4"));
                add(new FootballPlayer("Test5"));
                add(new FootballPlayer("Test6"));
                add(new FootballPlayer("Test7"));
                add(new FootballPlayer("Test8"));
                add(new FootballPlayer("Test9"));
                add(new FootballPlayer("Test10"));
                add(new FootballPlayer("Test11"));

            }
        };
        // PERFORMANCE RATING A
        HashMap<AbstractPlayer, Integer> performanceRatingTeamA = new HashMap<>() {
            {
                for (int i = 0; i < footballPlayerListA.size(); i++) {
                    put(footballPlayerListA.get(i), (int)(Math.random() * 10) + 1);
                }
            }
        };
        // PERFORMANCE RATING B
        HashMap<AbstractPlayer, Integer> performanceRatingTeamB = new HashMap<>(){
            {
                for (int i = 0; i < footballPlayerListB.size(); i++) {
                    put(footballPlayerListB.get(i), (int)(Math.random() * 10) + 1);
                }
            }
        };

        /* CREATING TEAMS */
        ArrayList<Teams> teamList = new ArrayList<>() {
            {
                add(new Teams("TeamA", "Red", footballPlayerListA, performanceRatingTeamA));
                add(new Teams("TeamB", "Blue", footballPlayerListB, performanceRatingTeamB));

            }
        };

        /* CREATE SCORE MAP */
        HashMap<Teams, Integer> scoreMap = new HashMap<>(){
            {
                for (int i = 0; i < teamList.size(); i++) {
                    put(teamList.get(i), teamList.get(i).getScore());
                }
            }
        };

        /* DESCRIBE A FOOTBALL MATCH
         * THE PROGRAM SHOULD REPRESENT:
         * TWO OPPONENT TEAMS
         * THE LINEUPS
         * THE FINAL SCORE
         * THE SCORERS
         * PERFORMANCE RATING FOR EACH PLAYER
         * MAN OF THE MATCH
         */

        FootballMatch footballMatch = new FootballMatch(teamList, scoreMap, 90, "London");

        System.out.println("Welcome to " + footballMatch.getLocation() + "'s " + footballMatch.MATCHTYPE + " Match");
        
        System.out.print("\n");

        System.out.println("We present the following teams: ");
        presentTeams(teamList);

        System.out.print("\n");
        
        System.out.println("This match score is:");
        presentMatchScore(teamList);

        System.out.print("\n");

        System.out.println("This match scorers");
        presentScorers(teamList);

        System.out.print("\n");
  
        System.out.println("Team A Performance Ratings");
        presentPerformanceRating(teamList.get(0));

        System.out.print("\n");

        System.out.println("Team B Performance Ratings");
        presentPerformanceRating(teamList.get(1));

        System.out.println("The man of the game is: " + calculateManOfTheGame(teamList).getName());

    }

    public static void presentTeams(ArrayList<Teams> teamList){
        for (int i = 0; i < teamList.size(); i++) {
            System.out.println(teamList.get(i).getName());
            System.out.print("\n");
            for (int j = 0; j < teamList.get(i).getListOfPlayers().size(); j++) {
                System.out.println(teamList.get(i).getListOfPlayers().get(j).getName());
            }
            System.out.print("\n");
        }
    }

    public static void presentMatchScore(ArrayList<Teams> teamList){
        for (int i = 0; i < teamList.size()/2; i++) {
            System.out.println(teamList.get(i).getName() + " " + teamList.get(i).getScore() + " - " + teamList.get(i+1).getScore() + " " + teamList.get(i+1).getName());
        }
    };

    public static void presentScorers(ArrayList<Teams> teamList){

        for (int i = 0; i < teamList.size(); i++) {
            for (int j = 0; j < teamList.get(i).getListOfPlayers().size(); j++) {
                if(teamList.get(i).getListOfPlayers().get(j).getScores() > 0){
                    System.out.println(teamList.get(i).getListOfPlayers().get(j).getName() + " scored " + teamList.get(i).getListOfPlayers().get(j).getScores() + " points." );
                }
            }
            
        }
    }

    public static void presentPerformanceRating(Teams team){
        for (AbstractPlayer player : team.getListOfPlayers()) {
            System.out.println(player.getName() + " performance: " + team.getPerformanceRatingList().get(player));
        }

    }

    public static AbstractPlayer calculateManOfTheGame(ArrayList<Teams> teamList){

        /* MAN OF THE GAME PERFORMANCE IS CALCULATED BY
         * Performance Rating + (Score * 2);
         */

        int manOfTheGamePerformanceRating = 0;
        int currentManOfTheGameIndex = 0;
        int currentManOfTheGameTeam = 0;

        for (int i = 0; i < teamList.size(); i++) {
            for (int j = 0; j < teamList.get(i).getListOfPlayers().size(); j++) {
                if(teamList.get(i).getListOfPlayers().get(j).getScores() + (teamList.get(i).getPerformanceRatingList().get(teamList.get(i).getListOfPlayers().get(j)) * 2) > manOfTheGamePerformanceRating){
                    manOfTheGamePerformanceRating = teamList.get(i).getListOfPlayers().get(j).getScores() + (teamList.get(i).getPerformanceRatingList().get(teamList.get(i).getListOfPlayers().get(j)) * 2);
                    currentManOfTheGameIndex = j;
                    currentManOfTheGameTeam = i;
                }
            }
        }

        return teamList.get(currentManOfTheGameTeam).getListOfPlayers().get(currentManOfTheGameIndex);
    }

}
