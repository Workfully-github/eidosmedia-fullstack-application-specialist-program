import java.util.HashMap;

public class Player {
    public String playerName, position;
    public Team playsFor;
    public int goalsScored, assissts;
    //playerRating holds the number of scored goals and assissts
    public double playerRating;

    //Constructor
    public Player(String playerName, String position, Team team) {
        this.playerName = playerName;
        this.position = position;
        this.playsFor = team;
        this.goalsScored = 0;
        this.assissts = 0;
    }

    //Getters & Setters
    public void scored() {
        goalsScored++;
        // playsFor.setGoals(this.goalsScored);
    }

    public void assissted() {
        assissts++;
    }

    public int getAssissts() {
        return assissts;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public double getPlayerRating() {
        playerRating = (goalsScored + assissts) / 2;
        return playerRating;
    }
}