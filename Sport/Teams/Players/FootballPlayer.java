package Sport.Teams.Players;

public class FootballPlayer extends AbstractPlayer {

    private static int idCounter = 0;
    
    public FootballPlayer(String name){
        this.name = name;
        this.playerID = idCounter++;
    }
}
