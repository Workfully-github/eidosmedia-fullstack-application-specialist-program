package Sport.Championships;

import java.util.ArrayList;
import java.util.HashMap;

import Sport.Scores.Score;
import Sport.Sports.FootballMatch;
import Sport.Teams.Teams;

public abstract class League {

    protected ArrayList<Teams> teamList;
    protected ArrayList<FootballMatch> footballMatchesLogMap = new ArrayList<>();
    protected HashMap<Teams, ArrayList<Score>> goalsLogMap = new HashMap<>();
    protected HashMap<Teams, Integer> victoryLogMap = new HashMap<>();
    protected HashMap<Teams, Integer> stalemateLogMap = new HashMap<>();
    protected HashMap<Teams, Integer> defeatLogMap = new HashMap<>();

    public League() {

    }

    /* INITIALIZE LOG MAPS */
    public abstract void logMapsInit();

    /* LEAGUE STANDING TABLE */
    public void presentStandingTable() {

        System.out.println("| TEAM | GOALS | V | S | D | PTS ");
        for (Teams team : teamList) {
            System.out.println(
                    StringPresentation.teamFormatter(team.getName()) +
                            StringPresentation.goalMapFormatter(goalsLogMap.get(team)) +
                            StringPresentation.victoryMapFormatter(victoryLogMap.get(team)) +
                            StringPresentation.stalemateMapFormatter(stalemateLogMap.get(team)) +
                            StringPresentation.defeatMapFormatter(defeatLogMap.get(team)) +
                            StringPresentation.pointCalculationAndPresentation(victoryLogMap.get(team),
                                    stalemateLogMap.get(team)));
        }
    }

    private HashMap<Teams, Integer> generatePtsLogMap() {
        return new HashMap<Teams, Integer>(){
            {
                for (Teams team : teamList) {
                    put(team, victoryLogMap.get(team) * 3 + stalemateLogMap.get(team));
                }
            }
        };
    }

    private ArrayList<Teams> sort(HashMap<Teams, Integer> ptsLogMap){

      

        return new ArrayList<Teams>();

    }

    /* GENERATE FOOTBALL MATCH */
    private FootballMatch generateFootballMatch(Teams homeTeam, Teams awayTeam) {

        return new FootballMatch(new ArrayList<Teams>() {
            {
                add(homeTeam);
                add(awayTeam);
            }
        });
    }

    /* METHODS */

    /*
     * GENERATE EVERY POSSIBLE FOOTBALL MATCH FOR WHOLE LEAGUE
     * MATCHES WILL BE AUTOMATICALLY PLAYED
     * GOALS WILL BE CALCULATED RANDOMLY ON EVERY MATCH AND WINNER DECLARED
     * IT IS POSSIBLE TO GENERATE STALEMATES
     * CHECK OUTPUT IN SANDBOX FOR BETTER UNDERSTANDING
     */
    public void generateAllFootballMatchesForThisLeague() {
        for (int i = 0; i < teamList.size(); i++) {
            for (int j = 0; j < teamList.size(); j++) {

                Teams homeTeam = teamList.get(i);
                Teams awayTeam = teamList.get(j);

                if (i != j)
                    footballMatchesLogMap.add(generateFootballMatch(homeTeam, awayTeam));
            }
        }

        populateStandingTable();
    }

    private ArrayList<Score> collectAllGoals(Teams team) {
        return new ArrayList<Score>() {
            {
                for (FootballMatch footballMatch : footballMatchesLogMap) {
                    if (footballMatch.getScoreMap().get(team) != null)
                        addAll(footballMatch.getScoreMap().get(team));
                }
            }
        };
    }

    private void countGoals() {
        for (Teams team : teamList) {
            goalsLogMap.put(team, collectAllGoals(team));
        }
    }

    private void verifyOutcomes(Teams team) {
        for (FootballMatch footballMatch : footballMatchesLogMap) {

            if (footballMatch.getTeamsList().contains(team)) {
                if (footballMatch.isStalemate()) {
                    stalemateLogMap.put(team, stalemateLogMap.get(team) + 1);
                    continue;
                }
                if (footballMatch.getWinner() == team) {
                    victoryLogMap.put(team, victoryLogMap.get(team) + 1);
                    continue;
                }
                if (footballMatch.getLoser() == team) {
                    defeatLogMap.put(team, defeatLogMap.get(team) + 1);
                    continue;
                }
            }
        }
    }

    private void populateStandingTable() {

        countGoals();

        for (Teams team : teamList) {
            verifyOutcomes(team);
        }
    }

    /* GETTERS */
    public ArrayList<Teams> getTeamList() {
        return teamList;
    }

}
