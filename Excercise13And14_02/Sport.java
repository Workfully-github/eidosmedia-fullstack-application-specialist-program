package Excercise13And14_02;

public class Sport {
    protected String name;
    protected int numberOfPlayers;

    public Sport(String name, int numberOfPlayers) {
        this.name = name;
        this.numberOfPlayers = numberOfPlayers;
    }

    public String printInfo() {
        return name + " is a sport played by " + numberOfPlayers + " number of players" ;
    }
    
    
}
