package Sport.Championships;

import java.util.ArrayList;
import java.util.HashMap;

import Sport.Scores.Goal;
import Sport.Teams.Teams;

public abstract class League {

    protected ArrayList<Teams> teamList;
    protected HashMap<Teams, ArrayList<Goal>> goalsLogMap = new HashMap<>();
    protected HashMap<Teams, Integer> victoryLogMap = new HashMap<>();
    protected HashMap<Teams, Integer> stalemateLogMap = new HashMap<>();
    protected HashMap<Teams, Integer> defeatLogMap = new HashMap<>();

    public League(){

    }

    /* Initialize Log Maps */
    public abstract void logMapsInit();
    
    /* LEAGUE STANDING TABLE */

    public void presentStandingTable(){

        System.out.println("| TEAM | GOALS | V | S | D | PTS ");
        for (Teams team : teamList) {
            System.out.println(
                StringPresentation.teamFormatter(team.getName()) + 
                StringPresentation.goalMapFormatter(goalsLogMap.get(team)) +
                StringPresentation.victoryMapFormatter(victoryLogMap.get(team)) + 
                StringPresentation.stalemateMapFormatter(stalemateLogMap.get(team)) +
                StringPresentation.defeatMapFormatter(defeatLogMap.get(team)) + 
                StringPresentation.pointCalculationAndPresentation(victoryLogMap.get(team), stalemateLogMap.get(team))
                );
        }
    }
    
}
