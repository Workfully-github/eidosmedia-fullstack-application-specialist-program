import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import javax.sound.midi.Track;

public class League {
    public String leagueName;
    public HashMap<Team, Team>leagueMatchs;
    public ArrayList<Team>currentMatchTeams;
    private ArrayList<Team>OrderedTeamList = new ArrayList<Team>();

    public League(String leagueName) {
        this.leagueName = leagueName;
        leagueMatchs = new HashMap<Team, Team>();
        currentMatchTeams = new ArrayList<Team>();
    }

    public void setLeagueMatchs(Team F, Team S) {
        this.leagueMatchs.put(F, S);
    }

    public HashMap<Team, Team> getLeagueMatchs() {
        return leagueMatchs;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setCurrentMatchTeams(Team currentMatchTeam) {
        this.currentMatchTeams.add(currentMatchTeam);
    }

    public void cleanCurrentMatchTeams() {
        this.currentMatchTeams = new ArrayList<>();
    }

    public Team getCurrentMatchTeams(int teamIndex) {
        return currentMatchTeams.get(teamIndex);
    }
    
    public ArrayList<Team> getCurrentMatchTeams() {
        return currentMatchTeams;
    }

    public boolean isLeagueMatchExist(Team F, Team S) {
        for(Team leagueMatchTeam : leagueMatchs.keySet()){
            if((leagueMatchTeam == F || leagueMatchTeam == S) && (leagueMatchs.get(leagueMatchTeam) == F || leagueMatchs.get(leagueMatchTeam) == S) )
            return true;
        }
        return false;
    }

    public void getLeagueStanding(ArrayList<Team> teams) {
        System.out.println("Clube   |   Points  |   Wins    |   Nulls   |   Losses  |");
        
        Collections.sort(teams, new Comparator<Team>() {
            
            @Override
            public int compare(Team o1, Team o2) {
                return o1.getPts() - o2.getPts() ;
            }
        });

        for(Team team : teams) {
            System.out.println(team.getTeamName() + "    |   " + team.getPts() + "    |   " + team.getWins() + "    |   " + team.getNulls() + "    |   " + team.getLosses());
        }

    }
}
