package Sport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import Sport.Scores.Score;
import Sport.Sports.FootballMatch;
import Sport.Teams.Teams;
import Sport.Teams.Players.AbstractPlayer;
import Sport.Teams.Players.FootballPlayer;

public class SandboxLEGACY {

    public static void main(String[] args) {

        /* TIP: COLLAPSE ALL METHODS FOR BETTER VIEW */

        /* BOOTSTRAPING VALUES */
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
        // RANDOMLY GENERATES PERFORMANCE RATING FROM 1 TO 10
        HashMap<AbstractPlayer, Integer> performanceRatingTeamA = new HashMap<>() {
            {
                for (int i = 0; i < footballPlayerListA.size(); i++) {
                    put(footballPlayerListA.get(i), (int)(Math.random() * 10) + 1);
                }
            }
        };
        // PERFORMANCE RATING B
        // RANDOMLY GENERATES PERFORMANCE RATING FROM 1 TO 10
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

        /* SCANNING INPUT */
        
        scanScorer(teamList);

        

        /* CREATE SCORE MAP */
        HashMap<Teams, Score> scoreMap = new HashMap<>(){
            {
                for (int i = 0; i < teamList.size(); i++) {
                    
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

        /* FootballMatch footballMatch = new FootballMatch(teamList, scoreMap, 90, "London");

        System.out.println("Welcome to " + footballMatch.getLocation() + "'s " + footballMatch.MATCHTYPE + " Match");
        
        System.out.print("\n");

        System.out.println("We present the following teams: ");
        footballMatch.presentTeams(footballMatch.getTeamsList());

        System.out.print("\n");
        
        System.out.println("This match score is:");
        footballMatch.presentMatchScore(footballMatch.getTeamsList());

        System.out.print("\n");

        System.out.println("This match scorers");
        footballMatch.presentScorers(footballMatch.getTeamsList());

        System.out.print("\n");
  
        System.out.println("Team A Performance Ratings");
        footballMatch.presentPerformanceRating(footballMatch.getTeamsList().get(0));

        System.out.print("\n");

        System.out.println("Team B Performance Ratings");
        footballMatch.presentPerformanceRating(footballMatch.getTeamsList().get(1));

        System.out.print("\n");

        System.out.println("The man of the game is: " + footballMatch.calculateManOfTheGame(footballMatch.getTeamsList()).getName()); */

    }

    public static HashMap<Teams, AbstractPlayer> scanScorer(ArrayList<Teams> teams){

        Scanner scGoal = new Scanner(System.in);

        System.out.println("What Team scored?");
        System.out.println("1 - TEAM A: ");
        System.out.println("2 - TEAM B: ");

        int choice = scGoal.nextInt();

        if(choice == 1){

            Teams selectedTeam = teams.get(choice-1);

            int counter = 0;

            ArrayList<AbstractPlayer> playerList = selectedTeam.getListOfPlayers();

            
            System.out.println("What player scored?");


            for (AbstractPlayer player : playerList) {
                counter++;
                System.out.println(counter + " - " + player.getName());
            }

            scGoal = new Scanner(System.in);
   
            return new HashMap<Teams, AbstractPlayer>()
            { 
                {
                    put(selectedTeam, selectedTeam.getListOfPlayers().get(scGoal.nextInt() -1));
                }
            };
        }

        if(scGoal.nextInt() == 2){

            scGoal = new Scanner(System.in);

            System.out.println("What player scored?");

            int counter = 0;

            Teams selectedTeam = teams.get(scGoal.nextInt()-1);

            for (AbstractPlayer player : selectedTeam.getListOfPlayers()) {
                counter++;
                System.out.println(counter + " - " + player.getName());
            }

            return selectedTeam.getListOfPlayers().get(scGoal.nextInt() -1);
        }

        System.out.println("You need to select a valid option.");
        return null;
    }

}

/* update the score goals live: each time a player scores i want to have an input to have a goal
 * implement scanner
 * create a goal class object and assign it to the team
 * ask information to assign a goal
 */