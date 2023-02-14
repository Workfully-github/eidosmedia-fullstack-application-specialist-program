package Football;

public class ChampionsFinal {


    public static void main(String[] args) {

        FootballMatch championsFinal;
        FootballTeam homeTeam,awayTeam;
        homeTeam = getHomeTeam();
        awayTeam = getAwayTeam();
        ArrayList<FootballTeam> finalOpponents = new ArrayList<FootballTeam>();
        finalOpponents.add(homeTeam);
        finalOpponents.add(awayTeam);

        
       championsFinal = new FootballMatch(finalOpponents, "Istanbul", "Collina");


       Goal goal1 = scoredGoal(homeTeam.getPlayers().get(5), 35);
       Goal goal2 = scoredGoal(homeTeam.getPlayers().get(5), 35,homeTeam.getPlayers().get(3));

       championsFinal.scoreAGoal(goal);






        
    }


    private static Goal scoredGoal(FootballPlayer scorer, int minute){
        scoredGoal(scorer, minute,null);
    }

    private static Goal scoredGoal(FootballPlayer scorer, int minute, FootballPlayer assistant){
        return new Goal(scorer, minute, assistant);
    }



    private static FootballTeam getHomeTeam(){

        //TODO

    }

    private static FootballTeam getAwayTeam(){

        //TODO 


    }

}