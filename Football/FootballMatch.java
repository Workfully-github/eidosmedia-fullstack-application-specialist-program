package Football;

public class FootballMatch {

    private static final int DURATION = 90;

    private ArrayList<FooballTeam> teams; 
    private String location;
    private String referee;

    private ArrayList<Goal> goals = new ArrayList<Goal>();

    public FootballMatch(ArrayList<FooballTeam> teams, String location,String referee){
        this.teams = teams;
        this.location = location;
        this.referee = referee;

    }


    public void scoreAGoal(Goal goal){
        goals.add(goal);

    }










}