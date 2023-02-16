import java.util.HashMap;
import java.util.Map;

public class Goal{

    private FootballPlayer scorer;
    private int minute;
    private FootballTeam team;
    private League league;
    private FootballMatch match;

    
    public Goal(League league, FootballTeam team, FootballPlayer scorer, int minute){
        this.league = league;
        this.scorer = scorer;
        this.minute = minute;
        this.team = team;
    }

    public FootballTeam getTeam() {
        return team;
    }

    public League getLeague() {
        return league;
    }

    public FootballPlayer getScorer() {
        return scorer;
    }
}