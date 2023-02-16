package Soccer_Match;

public class SoccerPlayer {
    
    private String name;
    private int number;
    private String nationality;

    public SoccerPlayer(String name, int number, String nationality) {
        this.name = name;
        this.number = number;
        this.nationality = nationality;
    }

    public String getPlayerName() {
        return name;
    }
}
