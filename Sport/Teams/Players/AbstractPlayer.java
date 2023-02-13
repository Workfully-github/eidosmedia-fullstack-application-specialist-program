package Sport.Teams.Players;

public class AbstractPlayer {

    protected String name;
    protected int scores;

    public AbstractPlayer(){
       this.scores = calculateTimesScored();
    }

    private int calculateTimesScored(){

        int randomChance = (int) Math.floor((Math.random() * 10) + 1);

        if(randomChance > 9){
            return (int) Math.floor((Math.random() * 3) + 1);
        }

        if(randomChance > 8){
            return (int) Math.floor((Math.random() * 1) + 0);
        }

        return 0;
    }

    public String getName() {
        return name;
    }
    public int getScores() {
        return scores;
    }

    
    
}
