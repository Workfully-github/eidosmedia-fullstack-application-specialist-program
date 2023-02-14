package Sport.Scores;

import Sport.Teams.Players.FootballPlayer;

public class Goal extends Score{

    private FootballPlayer scorer;
    private FootballPlayer assitant;
    private int minute;

    /* GETTERS */
    public FootballPlayer getScorer() {
        return scorer;
    }
    public FootballPlayer getAssitant() {
        return assitant;
    }
    public int getMinute() {
        return minute;
    }
    
}
