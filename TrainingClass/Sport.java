public class Sport {
    
    public String name;
    public int numbPlayers;

    public Sport(String name, int numbPlayers) {
        this.name = name;
        this.numbPlayers= numbPlayers;
    }

    public void printInfo() {
        System.out.println(name + " is a sport played by " + numbPlayers + " players");
    }
}
