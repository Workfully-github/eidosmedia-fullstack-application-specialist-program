import java.util.ArrayList;
import java.util.HashMap;

public class TennisMatch {
    
    public Sport tennis;
    public String location;
    private HashMap<Player, Integer> score = new HashMap<Player, Integer>();
    public int duration;
    public ArrayList<Player> players = new ArrayList();
    private Player winner;

    public TennisMatch(ArrayList<Player> players,HashMap<Player, Integer> score, String location, int duration) {
        this.score = score;
        this.location = location;
        this.players = players;
        this.duration = duration;
    }

    public void showMatchInfo() {
        System.out.println("This game was " + players.get(0).name + " vs " + players.get(1).name + " played in " + location);
        System.out.println("The final score was " + getReadableFinalScore());
    }

    public Player getMatchWinner() {
        if(score.get(players.get(0)) > score.get(players.get(1))) {
            winner = players.get(0);
            winner.numbWins ++;
            return winner;
        } else {
            winner = players.get(1);
            winner.numbWins ++;
            return winner;
        }
    }

    private String getReadableFinalScore() {
        
        return "";
    }

    /* public void findWinner() {
        String[] newScore = score.split("-");
        int score1 = Integer.parseInt(newScore[0]);
        int score2 = Integer.parseInt(newScore[1]);

        if (score1 > score2) {
            winner = player1.name;
            player1.numbWins ++;
            player2.numbLosses ++;
            player1.numbMatches ++;
            player2.numbMatches ++;

        } else {
            winner = player2.name;
            player2.numbWins ++;
            player1.numbLosses ++;
            player2.numbMatches ++;
            player1.numbMatches ++;
        }

        System.out.println(winner);
        System.out.println(player1.numbWins);
        System.out.println(player1.numbLosses);
        System.out.println(player1.numbMatches);

    } */

}
