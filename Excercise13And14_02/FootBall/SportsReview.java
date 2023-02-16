package Excercise13And14_02.FootBall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import Excercise13And14_02.Player;

public class SportsReview {

    public static void main(String[] args) {
        //football review
        String[] namesTeam1 = {"casilas", "piquet","allo","omar","kassim","zack","yves","tonny","Aziz","Raouf","Rene"};
        int[] numbersMatchWins1 = {0, 4,3,5,6,1,0,6,0,3,3};
        int[] performences1 = {0, 4,3,5,6,1,0,6,0,3,3};
        String[] namesTeam2 = {"casi", "Las","lopez","lahe","moctar","uno","yves","tonny","dado","David","Xavier"};
        int[] numbersMatchWins2 = {0,1,0,5,0,3, 4,3,5,5,3};
        int[] performences2 = {0, 4,3,5,5,1,0,6,0,3,3};
        ArrayList<Player> listPlayer1 =new ArrayList<>();
        ArrayList<Player> listPlayer2 =new ArrayList<>();

        for(int i=0; i<11;i++){
            listPlayer1.add(new Player(namesTeam1[i],numbersMatchWins1[i], performences1[i]));
            listPlayer2.add(new Player(namesTeam2[i],numbersMatchWins2[i], performences2[i]));
        }
        FootBallTeam team1 = new FootBallTeam(listPlayer1,"PSG");
        FootBallTeam team2 = new FootBallTeam(listPlayer2,"Real");
        ArrayList<FootBallTeam> teams = new ArrayList<>();
        teams.add(team1);
        teams.add(team2);
        HashMap<FootBallTeam, Integer> score = new HashMap<FootBallTeam,Integer>();
        score.put(team1, 1);
        score.put(team2, 2);
        FootBallMatch footMatch = new FootBallMatch(teams, 60, score, "Paris");
        footMatch.showMatchInfos();

        //Goal code implementation
        Goal goal0 = scoredGoal(teams.get(0).getTeamPlayers().get(5), 35);
        Scanner sc= new Scanner(System.in);    //System.in is a standard input stream  
        System.out.print("\nTest for manuel parameters####");  
        System.out.print("\nEnter the team number (0/1)- ");  
        int numTeam= sc.nextInt();  
        System.out.print("Enter the player number- ");  
        int numPlayer= sc.nextInt();  
        System.out.print("Enter the minute - ");
        int minute= sc.nextInt();  
        Goal goal1 = scoredGoal(teams.get(numTeam).getTeamPlayers().get(numPlayer), minute);
        footMatch.scoredAGoal(goal1);

        System.out.println(goal1.toString());

        //the part for the ligue standings
        Ligue championLigue = new Ligue(teams, "14/02/2023", "12/06/2023");

        TeamPerformence performenceTeam1 = new TeamPerformence(4, 2, 0, 2);
        TeamPerformence performenceTeam2 = new TeamPerformence(7, 6, 1, 2);
        championLigue.addTeamAndStat(team2, performenceTeam2);
        championLigue.addTeamAndStat(team1, performenceTeam1);
        championLigue.addGoal(goal0);
        championLigue.addGoal(goal1);
        championLigue.addGoal(goal1);
        championLigue.addMatch(footMatch);
        championLigue.showStanding();
        championLigue.showScorePlayer();

        team1.showBestPlayerBy("goal");
    
    }

    private static Goal scoredGoal(Player player, int minute){
        return scoredGoal(player, minute,null);
    }

    private static Goal scoredGoal(Player scorer, int minute, Player assistant){
        return new Goal(scorer, minute,assistant);
    }

}
