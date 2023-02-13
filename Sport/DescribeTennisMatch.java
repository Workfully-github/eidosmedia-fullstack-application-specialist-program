public class DescribeTennisMatch {
    String[] players;
    int[] scorre;
    String matchPlace, winner;
    int duration;

    

    public DescribeTennisMatch(String[] players, int[] scorre, String matchPlace, String winner, int duration){
        this.players = players;
        this.scorre = scorre;
        this.matchPlace = matchPlace;
        this.winner = winner;
        this.duration = duration;
    }

    public void printMatchInfo() {
        System.out.println("A great match between " + players[0] + " and " + players[1] + " at the "  + matchPlace +  ", the scorre was "  + scorre[0] + " - " + scorre[1] + "to " + winner);
    }

   

}
