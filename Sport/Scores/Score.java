package Sport.Scores;

import Sport.Teams.Players.AbstractPlayer;

public abstract class Score {

    protected AbstractPlayer scorer;
    protected AbstractPlayer assitant;
    protected int minute;

    /* GETTERS */
    public AbstractPlayer getScorer() {
        return scorer;
    }

    public AbstractPlayer getAssitant() {
        return assitant;
    }
    public int getMinute() {
        return minute;
    }
    
}
