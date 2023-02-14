package Soccer_Match;

public class SoccerPlayer {
    
    private String name;
    private int number;
    private String nationality;
    private int goalsScored;
    private int gamesPlayed;

    public SoccerPlayer(String name, int number, String nationality, int goalsScored, int gamesPlayed) {
        this.name = name;
        this.number = number;
        this.nationality = nationality;
        this.goalsScored = goalsScored;
        this.gamesPlayed = gamesPlayed;
    }

    public String getPlayerName() {
        return name;
    }

    public int getPlayerNumber() {
        return number;
    }

    public int getPlayerScoredGoals() {
        return goalsScored;
    }

    public void setGoalsScored(int goals) {
        goalsScored = goals;
    }

    public int getPlayerGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int games) {
        gamesPlayed = games;
    }

    public String getNationality() {
        return nationality;
    }
}
