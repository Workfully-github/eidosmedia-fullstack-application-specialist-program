package Soccer_Match;

import java.util.ArrayList;
import java.util.HashMap;

public class PremierLeague {
    public static void main(String[] args) {

        SoccerLeague premierLeague = new SoccerLeague("Premier League 2022-2023", getPremierLeagueTeams());
        premierLeague.setMatches(getMatchesCalendar());

        premierLeague.playMatches();

        HashMap<SoccerTeam, Integer> table = premierLeague.getStandings();

        for (int i = 0; i < table.size(); i++) {
            System.out.println(table.get(i));
        }
        
    }

    // Create array with all the teams in the league
    private static ArrayList<SoccerTeam> getPremierLeagueTeams(){
        ArrayList<SoccerTeam> premierTeams = new ArrayList<SoccerTeam>() {
            {
                add(setPremierTeam("Manchester City", setAllTeam(), "Guardiola", "Manchester"));
                add(setPremierTeam("Manchester United", setAllTeam(), "Ten Haag", "Manchester"));
                add(setPremierTeam("Liverpool", setAllTeam(), "Klopp", "Liverpool"));
                add(setPremierTeam("Newcastle", setAllTeam(), "Howe", "Newcastle"));
            }
        } ;

        return premierTeams;
    }

    // Create a single team
    private static SoccerTeam setPremierTeam(String name, ArrayList<SoccerPlayer> players, String coach, String city){
        SoccerTeam team = new SoccerTeam(name, players, coach, city);
        return team;
    }

    // Create array of players
     private static ArrayList<SoccerPlayer> setAllTeam() {
        ArrayList<SoccerPlayer> players = new ArrayList<SoccerPlayer>() {
            {for (int i = 1; i <= 11; i++) {
                add(setSinglePlayer("Player " + i, i, "Some"));
                }}};
        return players;
    }

    // Create a single player
    private static SoccerPlayer setSinglePlayer(String name, int number, String nationality) {
        SoccerPlayer player = new SoccerPlayer(name, number, nationality);
        return player;
    }

    private static ArrayList<SoccerMatch> getMatchesCalendar(){
        ArrayList<SoccerMatch> allMatches = new ArrayList<SoccerMatch>() {
            {
                    add(new SoccerMatch(getTeamsForMatch(getPremierLeagueTeams().get(0),
                    getPremierLeagueTeams().get(1)), "Somewhere", "Someone"));
                    add(new SoccerMatch(getTeamsForMatch(getPremierLeagueTeams().get(2),
                    getPremierLeagueTeams().get(3)), "Somewhere", "Someone"));
                    add(new SoccerMatch(getTeamsForMatch(getPremierLeagueTeams().get(0),
                    getPremierLeagueTeams().get(3)), "Somewhere", "Someone"));
                    add(new SoccerMatch(getTeamsForMatch(getPremierLeagueTeams().get(2),
                    getPremierLeagueTeams().get(1)), "Somewhere", "Someone"));
                    add(new SoccerMatch(getTeamsForMatch(getPremierLeagueTeams().get(0),
                    getPremierLeagueTeams().get(2)), "Somewhere", "Someone"));
                    add(new SoccerMatch(getTeamsForMatch(getPremierLeagueTeams().get(1),
                    getPremierLeagueTeams().get(3)), "Somewhere", "Someone"));
            }
        };

        return new ArrayList<SoccerMatch>();
    }

    private static ArrayList<SoccerTeam> getTeamsForMatch(SoccerTeam home, SoccerTeam away) {
        ArrayList<SoccerTeam> game = new ArrayList<SoccerTeam>() {
            {
                add(home);
                add(away);
            }
        };
        return game;
    }

}