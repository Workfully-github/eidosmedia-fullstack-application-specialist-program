package Excercise13And14_02.FootBall;

public class TeamPerformence {
    private int numberMatch;
    private int points;
    private int scoredGoal;
    private int concededGoal;

    public TeamPerformence(int points, int scoredGoal, int concededGoal, int numberMatch) {
        this.points = points;
        this.scoredGoal = scoredGoal;
        this.concededGoal = concededGoal;
        this.numberMatch = numberMatch;
    }
    

    
    @Override
    public String toString() {
        return " TeamPerformence [numberMatch=" + numberMatch + ", points=" + points + ", scoredGoal=" + scoredGoal
                + ", concededGoal=" + concededGoal + "]\n";
    }



    public int getPoints() {
        return points;
    }


    public void setPoints(int points) {
        this.points = points;
    }


    public int getScoredGoal() {
        return scoredGoal;
    }


    public void setScoredGoal(int scoredGoal) {
        this.scoredGoal = scoredGoal;
    }


    public int getConcededGoal() {
        return concededGoal;
    }


    public void setConcededGoal(int concededGoal) {
        this.concededGoal = concededGoal;
    }


    public int getNumberMatch() {
        return numberMatch;
    }


    public void setNumberMatch(int numberMatch) {
        this.numberMatch = numberMatch;
    }


    
}
