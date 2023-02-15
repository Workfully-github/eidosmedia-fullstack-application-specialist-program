package Sport.Championships;

import java.util.ArrayList;

import Sport.Teams.Teams;

public class NationalLeague extends League{


    /* CONSTRUCTOR */
    public NationalLeague(){
        
    }

    public NationalLeague(ArrayList<Teams> teamList){
        this.teamList = teamList;
        logMapsInit();
    }

    /* GETTERS */

    @Override
    public void logMapsInit() {
        for (Teams team : teamList) {
            goalsLogMap.put(team, new ArrayList<>());
            victoryLogMap.put(team, 0);
            stalemateLogMap.put(team, 0);
            defeatLogMap.put(team, 0);
        }
        
    }

    
}
