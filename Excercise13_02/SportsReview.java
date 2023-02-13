package Excercise13_02;

import java.util.ArrayList;
import java.util.HashMap;

import Excercise13_02.FootBall.FootBallMatch;
import Excercise13_02.FootBall.FootBallTeam;

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
    }
}
