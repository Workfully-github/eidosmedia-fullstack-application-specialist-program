public class Sport{
    //Reminder!! Change the array to an ArrayList
   public String name;
   public int numberOfPlayers;

   public Sport(String name, int numberOfPlayers) {
        this.name = name;
        this.numberOfPlayers = numberOfPlayers;
    }
    public void printInfo() {
        System.out.println(name + " is a sport played by " + numberOfPlayers + " number of players.");
    }

}

