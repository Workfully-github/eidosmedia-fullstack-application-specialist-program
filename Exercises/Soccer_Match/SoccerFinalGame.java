package Soccer_Match;

import java.util.ArrayList;

import Football_Match.FootballPlayers;

public class SoccerFinalGame {
    
    public static void main(String[] args) {

        SoccerLeague englandCup;
        SoccerMatch cityVsLiverpool;
        SoccerTeam manchesterCity;
        SoccerTeam liverpool;
        ArrayList<SoccerTeam> oponnents = new ArrayList<SoccerTeam>();

        oponnents.add(manchesterCity);
        oponnents.add(liverpool);

        cityVsLiverpool = new SoccerMatch(oponnents, "Lisbon", "Soares Dias");

        // Create League
        englandCup = new SoccerLeague("England Cup", oponnents, null, null, null, null, null, null, null)
        // Need to create the missing fields to complete league

        manchesterCity = getHomeTeam("Manchester City", ArrayList<SoccerPlayer> players, "Guardiola", "Manchester");
        liverpool = getAwayTeam("Liverpool", players, "Klopp", "Liverpool");

        // Create goals
        SoccerGoal goalCity1 = scoreGoal(manchesterCity.getPlayers().get(6), 12, manchesterCity.getPlayers().get(6), manchesterCity);
        SoccerGoal goalCity2 = scoreGoal(manchesterCity.getPlayers().get(1), 25, manchesterCity.getPlayers().get(8), manchesterCity);
        SoccerGoal goalLiverpool1 = scoreGoal(liverpool.getPlayers().get(3), 44, liverpool.getPlayers().get(5), liverpool);
        SoccerGoal goalLiverpool2 = scoreGoal(liverpool.getPlayers().get(2), 56, liverpool);
        
        // Score goals
        cityVsLiverpool.scoreAGoal(goalCity1);
        cityVsLiverpool.scoreAGoal(goalCity2);
        cityVsLiverpool.scoreAGoal(goalLiverpool1);
        cityVsLiverpool.scoreAGoal(goalLiverpool2);
    }

    private static SoccerTeam getHomeTeam(String name, ArrayList<SoccerPlayer> players, String coach, String city) {
        SoccerTeam homeTeam = new SoccerTeam(name, players, coach, city);  
        return homeTeam;
    }

    private static SoccerTeam getAwayTeam(String name, ArrayList<SoccerPlayer> players, String coach, String city) {
        SoccerTeam awayTeam = new SoccerTeam(name, players, coach, city);  
        return awayTeam;
    }

    private static SoccerGoal scoreGoal(SoccerPlayer scorer, int minute, SoccerPlayer assistant, SoccerTeam team) {
        SoccerGoal goal = new SoccerGoal(scorer, minute, assistant, team);
        return goal;
    }

    private static SoccerGoal scoreGoal(SoccerPlayer scorer, int minute, SoccerTeam team) {
        SoccerGoal goal = scoreGoal(scorer, minute, null, team);
        return goal;
    }
}
