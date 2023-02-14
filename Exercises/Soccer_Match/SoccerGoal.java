package Soccer_Match;

public class SoccerGoal {
    
    private SoccerPlayer scorer;
    private int minute;
    private SoccerPlayer assistant;
    private SoccerTeam team;

    public SoccerGoal(SoccerPlayer scorer, int minute, SoccerPlayer assistant, SoccerTeam team) {
        this.scorer = scorer;
        this.minute = minute;
        this.assistant = assistant;
        this.team = team;
    }

    public SoccerPlayer getScorer() {
        return scorer;
    }

    public int getMinuteScore() {
        return minute;
    }

    public SoccerPlayer getAssistant() {
        return assistant;
    }

    public SoccerTeam getTeam() {
        return team;
    }
}
