package Sport.Scores;

import Sport.Teams.Players.*;

public class Goal extends Score{

   /*  private FootballPlayer scorer;
    private FootballPlayer assitant;
    private int minute; */

    /* EMPTY CONSTRUCTOR */
    public Goal(){

    }
    /* CONSTRUCTOR ONE */
    public Goal(FootballPlayer scorer, FootballPlayer assitant, int minute) {
        this.scorer = scorer;
        this.assitant = assitant;
        this.minute = minute;
    }

    /* CONSTRUCTOR TWO */
    public Goal(FootballPlayer scorer, int minute) {
        this.scorer = scorer;
        this.minute = minute;
    }
    
}
