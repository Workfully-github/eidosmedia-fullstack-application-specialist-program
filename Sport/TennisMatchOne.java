public class TennisMatchOne {

    String[] players;
        int[] scorre;
        String matchPlace;
        String winner;
        int duration ;
        String finaleScoreTable;

    public TennisMatchOne(String[] players, int[] scorre, String matchPlace, int duration) {
        this.players = players;
        this.scorre = scorre;
        this.matchPlace = matchPlace;
        this.duration = duration;
        this.finaleScoreTable = "";
    }

    public void printInfo(){
        System.out.println("A great match between " + players[0] + " and " + players[1] + " at the "  + matchPlace +  ", the scorre was "  + scorre[0] + " - " + scorre[1] + " to " + winner);
    }

    public String getWinner(String[] players, int[] scorre){
        if(scorre[0] > scorre[1]){
            this.winner = players[0];
            return players[0];
        }
        this.winner = players[1];
        return players[1];
    }

    public String getReadableFinaleScore() {
        this.finaleScoreTable = players[0] + " --> " + scorre[0] + "\n" + players[1] + " --> " + scorre[1];
        return  this.finaleScoreTable;
    }

    public static void main(String[] args) {
        String[] players = {"Federer", "Nadal"};
        int[] scorre = {5, 6};
        String matchPlace = "Porto";
        int duration = 5 ;
        TennisMatchOne matchFedererNadal = new TennisMatchOne(players, scorre, matchPlace, duration);
        String winner = matchFedererNadal.getWinner(players, scorre);

        matchFedererNadal.printInfo();
        System.out.println("-----------------------------\n**** Match Final Score ****\n -----------------------------\n" + matchFedererNadal.getReadableFinaleScore() + "\n -----------------------------");
        System.out.println("Congrats to: " + winner + ", for winning!");
        Player theWinner = new Player(winner);
        System.out.println(theWinner.name + " had: " + theWinner.wins + " before this match.");
        theWinner.wins++; 
        System.out.println(theWinner.name + " now have: " + theWinner.getPlayerWins() + " wins.");

        //Create a readable String from a hashmap decribing tennis match score.
    }
}
