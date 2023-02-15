package Soccer_Match;

import java.util.ArrayList;
import java.util.HashMap;

public class SoccerFinalGame {
    
    public static void main(String[] args) {

        SoccerLeague englandCup;
        SoccerMatch cityVsLiverpool;
        SoccerMatch unitedVsNewcastle;
        SoccerTeam manchesterCity;
        SoccerTeam liverpoolFC;
        SoccerTeam manchesterUnited;
        SoccerTeam newcastleFC;

        ArrayList<SoccerTeam> oponnentsGame1 = new ArrayList<SoccerTeam>();
        ArrayList<SoccerTeam> oponnentsGame2 = new ArrayList<SoccerTeam>();
        ArrayList<SoccerTeam> leagueTeams = new ArrayList<SoccerTeam>();
        ArrayList<SoccerPlayer> city = new ArrayList<SoccerPlayer>();
        ArrayList<SoccerPlayer> liverpool = new ArrayList<SoccerPlayer>();
        ArrayList<SoccerPlayer> united = new ArrayList<SoccerPlayer>();
        ArrayList<SoccerPlayer> newcastle = new ArrayList<SoccerPlayer>();
        ArrayList<SoccerMatch> allMatches = new ArrayList<SoccerMatch>();

        HashMap<SoccerTeam, Integer> points = new HashMap<SoccerTeam, Integer>();
        HashMap<SoccerTeam, Integer> wins = new HashMap<SoccerTeam, Integer>();
        HashMap<SoccerTeam, Integer> losses = new HashMap<SoccerTeam, Integer>();
        HashMap<SoccerTeam, Integer> draws = new HashMap<SoccerTeam, Integer>();
        HashMap<SoccerTeam, Integer> goalsScored = new HashMap<SoccerTeam, Integer>();
        HashMap<SoccerTeam, Integer> goalsSuffered = new HashMap<SoccerTeam, Integer>();

        // Create matches
        cityVsLiverpool = new SoccerMatch(oponnentsGame1, "Wembley Stadium", "Soares Dias");
        unitedVsNewcastle = new SoccerMatch(oponnentsGame2, "Dragão", "Collina");

        // Create players
        setCityPlayers(city);
        setLiverpoolPlayers(liverpool);
        setUnitedPlayers(united);
        setNewcastlePlayers(newcastle);

        // Create League
        englandCup = new SoccerLeague("England Cup", leagueTeams, allMatches, points, wins, losses, draws, goalsScored, goalsSuffered);
        // Need to create the missing fields to complete league

        // Create teams
        manchesterCity = getHomeTeam("Manchester City", city, "Guardiola", "Manchester");
        liverpoolFC = getAwayTeam("Liverpool", liverpool, "Klopp", "Liverpool");
        manchesterUnited = getAwayTeam("Liverpool", united, "Klopp", "Liverpool");
        newcastleFC = getAwayTeam("Newcastle", newcastle, "Howe", "Newcastle");

        // Create goals
        SoccerGoal goalCity1 = scoreGoal(manchesterCity.getPlayers().get(6), 12, manchesterCity.getPlayers().get(6), manchesterCity);
        SoccerGoal goalCity2 = scoreGoal(manchesterCity.getPlayers().get(1), 25, manchesterCity.getPlayers().get(8), manchesterCity);
        SoccerGoal goalLiverpool1 = scoreGoal(liverpoolFC.getPlayers().get(3), 44, liverpoolFC.getPlayers().get(5), liverpoolFC);
        SoccerGoal goalLiverpool2 = scoreGoal(liverpoolFC.getPlayers().get(2), 56, liverpoolFC);
        
        // Score goals
        cityVsLiverpool.scoreAGoal(goalCity1);
        cityVsLiverpool.scoreAGoal(goalCity2);
        cityVsLiverpool.scoreAGoal(goalLiverpool1);
        cityVsLiverpool.scoreAGoal(goalLiverpool2);

        // Create oponnents array
        oponnentsGame1.add(manchesterCity);
        oponnentsGame1.add(liverpoolFC);
        
        oponnentsGame2.add(manchesterUnited);
        oponnentsGame2.add(newcastleFC);

        // Create array with teams in league
        leagueTeams.add(manchesterCity);
        leagueTeams.add(liverpoolFC);
        leagueTeams.add(manchesterUnited);
        leagueTeams.add(newcastleFC);

        // Create array with league matches
        allMatches.add(cityVsLiverpool);
        allMatches.add(unitedVsNewcastle);
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

    private static SoccerPlayer getHomeTeamPlayers(String name, int number, String nationality, int goalsScored, int gamesPlayed) {
        SoccerPlayer player = new SoccerPlayer(name, number, nationality, goalsScored, gamesPlayed);
        return player;
    }

    private static SoccerPlayer getAwayTeamPlayers(String name, int number, String nationality, int goalsScored, int gamesPlayed) {
        SoccerPlayer player = new SoccerPlayer(name, number, nationality, goalsScored, gamesPlayed);
        return player;
    }

    private static ArrayList<SoccerPlayer> setCityPlayers(ArrayList<SoccerPlayer> city) {
        //ArrayList<SoccerPlayer> homeTeamPlayers = new ArrayList<SoccerPlayer>();
        for (int i = 1; i <= 11; i++) {
            city.add(getHomeTeamPlayers("Player " + i, i, "Some", 0, 0));
        }
        return city;
    }

    private static ArrayList<SoccerPlayer> setLiverpoolPlayers(ArrayList<SoccerPlayer> liverpool) {
        //ArrayList<SoccerPlayer> homeTeamPlayers = new ArrayList<SoccerPlayer>();
        for (int i = 12; i <= 22; i++) {
            liverpool.add(getAwayTeamPlayers("Player " + i, i, "Some", 0, 0));
        }
        return liverpool;
    }

    private static ArrayList<SoccerPlayer> setUnitedPlayers(ArrayList<SoccerPlayer> united) {
        //ArrayList<SoccerPlayer> homeTeamPlayers = new ArrayList<SoccerPlayer>();
        for (int i = 23; i <= 33; i++) {
            united.add(getAwayTeamPlayers("Player " + i, i, "Some", 0, 0));
        }
        return united;
    }

    private static ArrayList<SoccerPlayer> setNewcastlePlayers(ArrayList<SoccerPlayer> newcastle) {
        //ArrayList<SoccerPlayer> homeTeamPlayers = new ArrayList<SoccerPlayer>();
        for (int i = 23; i <= 33; i++) {
            newcastle.add(getAwayTeamPlayers("Player " + i, i, "Some", 0, 0));
        }
        return newcastle;
    }
}

        /* SoccerPlayer player1 = getHomeTeamPlayers("Player 1", 1, "Some", 0, 0);
        SoccerPlayer player2 = getHomeTeamPlayers("Player 1", 1, "Some", 0, 0);
        SoccerPlayer player1 = getHomeTeamPlayers("Player 1", 1, "Some", 0, 0);
        SoccerPlayer player1 = getHomeTeamPlayers("Player 1", 1, "Some", 0, 0);
        SoccerPlayer player1 = getHomeTeamPlayers("Player 1", 1, "Some", 0, 0);
        SoccerPlayer player1 = getHomeTeamPlayers("Player 1", 1, "Some", 0, 0);
        SoccerPlayer player1 = getHomeTeamPlayers("Player 1", 1, "Some", 0, 0);
        SoccerPlayer player1 = getHomeTeamPlayers("Player 1", 1, "Some", 0, 0);
        SoccerPlayer player1 = getHomeTeamPlayers("Player 1", 1, "Some", 0, 0);
        SoccerPlayer player1 = getHomeTeamPlayers("Player 1", 1, "Some", 0, 0);
        SoccerPlayer player1 = getHomeTeamPlayers("Player 1", 1, "Some", 0, 0);
        SoccerPlayer player1 = getHomeTeamPlayers("Player 1", 1, "Some", 0, 0); */
