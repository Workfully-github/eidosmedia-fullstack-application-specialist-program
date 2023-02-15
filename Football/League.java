package Football;

public class League {

    private String name;
    private ArrayList<FootballTeam> teams;
    private ArrayList<FootballMatch> matches;
    private HashMap<FootballTeam,Integer> standings = new HashMap<FootballTeam,Integer>();

    private static int POINTS_WIN = 3;
    private static int POINTS_DRAW = 1;
    private static int POINTS_DEFAIT = 0;


    


    public League(String name,ArrayList<FootballTeam> teams){
        this.name = name;
        this.teams = teams;
        generateStandings();
    }



    /**
     * @param matches the matches to set
     */
    public void setMatches(ArrayList<FootballMatch> matches) {
        this.matches = matches;
    }


    public void playMatches(){
        // generate result of all league matches
        // assignPoints(match);
    }

    private void assignPoints(FootballMatch match){
        HashMap<FootballTeam,Integer> result = match.getResult();
    

        if(result.isADraw())
                // one point for each team
                return;

        //assign points to the winner        
        result.getWinner();


       // result.getLoser()





        // assign points to the teams based on match result 
    }

    private void generateStandings(){
        //TODO update the hashmap based on the teams
        // use alphabetical sorting

    }

    /**
     * @return the standings
     */
    public HashMap<FootballTeam, Integer> getStandings() {

        //TODO sort the standings based on value
        return standings;
    }


    




}