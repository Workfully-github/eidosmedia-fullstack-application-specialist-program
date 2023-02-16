package Soccer_Match;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Comparator;

public class SoccerTeam {
    
    private String name;
    private ArrayList<SoccerPlayer> players;
    private String coach;
    private String city;
    private HashMap<SoccerPlayer, Integer> scorers = new HashMap<SoccerPlayer,Integer>();

    public SoccerTeam(String name, ArrayList<SoccerPlayer> players, String coach, String city) {
        this.name = name;
        this.players = players;
        this.coach = coach;
        this.city = city;
    }

    public String getTeamName() {
        return name;
    }

    public ArrayList<SoccerPlayer> getPlayers() {
        return players;
    }
    
    public String getCoach() {
        return coach;
    }

    public String getCity() {
        return city;
    }

    public HashMap<SoccerPlayer, Integer> getTeamTopScorers() {
        ArrayList<HashMap.Entry<SoccerPlayer, Integer> > list =
               new ArrayList<HashMap.Entry<SoccerPlayer, Integer> >(scorers.entrySet());

        Collections.sort(list, new Comparator<HashMap.Entry<SoccerPlayer, Integer> >() {
            public int compare(HashMap.Entry<SoccerPlayer, Integer> o1,
            HashMap.Entry<SoccerPlayer, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        
        HashMap<SoccerPlayer, Integer> temp = new LinkedHashMap<SoccerPlayer, Integer>();
        for (HashMap.Entry<SoccerPlayer, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }

        return temp;
    }

    public void setTeamScorers(SoccerPlayer scorer) {
        scorers.put(scorer, 1);
    }
}
