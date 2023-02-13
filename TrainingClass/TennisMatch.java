public class TennisMatch {
    
    public Sport tennis;
    public String location, score, winner;
    public int duration;
    public Player player1, player2;

    public TennisMatch(Player player1, Player player2, String location, String score, String winner, int duration) {
        this.player1 = player1;
        this.player2 = player2;
        this.location = location;
        this.score = score;
        this.winner = winner;
        this.duration = duration;
    }

    public void describeGame() {
        System.out.println("This game was " + player1 + " vs " + player2 + " played in " + location + " and it took " + duration + " minutes ");
        System.out.println("The final winner was " + winner + " with a score of: " + score);
    }

    public void findWinner() {
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

/*         System.out.println(winner);
        System.out.println(player1.numbWins);
        System.out.println(player1.numbLosses);
        System.out.println(player1.numbMatches); */

    }

}
