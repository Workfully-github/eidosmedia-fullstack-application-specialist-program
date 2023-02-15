package Football;

public class FootballMatch {

    private static final int DURATION = 90;

    private ArrayList<FooballTeam> teams; 
    private String location;
    private String referee;
    private HasMap<FooballTeam,Integer> result = new HasMap<FooballTeam,Integer>();

    private ArrayList<Goal> goals = new ArrayList<Goal>();

    public FootballMatch(ArrayList<FooballTeam> teams, String location,String referee){
        this.teams = teams;
        this.location = location;
        this.referee = referee;
        
        // initialize result
        result.put(teams.get(0),0);
        result.put(teams.get(1),0);


    }


    public void scoreAGoal(Goal goal){
        goals.add(goal);

        int previuousResult = result.get(goal.getTeam());
        int newResult = previuousResult++;
        result.put(goal.getTeam(), newResult );

    }


    public HasMap<FooballTeam,Integer> getResult(){
        //TODO
        return result;


    }










}