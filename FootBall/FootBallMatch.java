import java.util.ArrayList;
import java.util.HashMap;
// import java.util.Map;
// import java.util.Set;

public class FootBallMatch {
    private ArrayList<Team>opponents;
    private String stadium, liga;
    private HashMap<Team, Integer> finaleScore;
    private ArrayList<Player>scorers;
    private Player MoM;
    private int mOfMatchAssissts;
    

    public FootBallMatch(
        ArrayList<Team>opponents,
        String stadium,
        String liga
        // HashMap<Team, Integer> finaleScore,
        // HashMap<Player, Integer>scorers,
        // Player MoM
        ){
            this.opponents = opponents;
            this.stadium = stadium;
            this.liga = liga;
            this.mOfMatchAssissts = 0;
            // this.mOfMatchIndex = 0;
            // this.finaleScore = finaleScore;
            // this.scorers = scorers;
            // this.MoM = MoM; 
        }

        public void setScorers(ArrayList<Player> scorers) {
            this.scorers = scorers;
        }

        public void getScorers() {
            System.out.println("\nThe Scorers for this match are: ");
            for(Player scorer : scorers){
                System.out.println(scorer.playerName + ". scored: " + scorer.getGoalsScored() + " goals.");
            }
            System.out.println("\n-------------------------\n");
    
        }

        public String getFinaleScore() {
            if(opponents.get(0).goals == 0 && opponents.get(1).goals == 0) return "Negative Null";
            
            return "finaleScore: =========== \n" + opponents.get(0).teamName + " : " + opponents.get(0).goals + "\n" + 
            opponents.get(1).teamName + " : " + opponents.get(1).goals ;
        }

        

        public void getMoM() {
            //Returning the top scorer with most assissts
            for(Player scorer : scorers){
                if(scorer.assissts > mOfMatchAssissts) {
                    MoM = scorer;
                }
            }
            System.out.print("\nThe Man of The Match for today is: " + MoM.playerName + "with " +MoM.goalsScored+ " Goals, " + MoM.assissts + " Assissts and Overall Rating of: " + MoM.getPlayerRating());
        }

}