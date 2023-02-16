package Sport.Championships;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import Sport.Scores.Score;
import Sport.Sports.FootballMatch;
import Sport.Teams.Teams;
import Sport.Teams.Players.AbstractPlayer;

public abstract class League {

    protected ArrayList<Teams> teamList;
    protected ArrayList<FootballMatch> footballMatchesLogMap = new ArrayList<>();
    protected HashMap<Teams, ArrayList<Score>> goalsLogMap = new HashMap<>();
    protected HashMap<Teams, Integer> victoryLogMap = new HashMap<>();
    protected HashMap<Teams, Integer> stalemateLogMap = new HashMap<>();
    protected HashMap<Teams, Integer> defeatLogMap = new HashMap<>();

    public League() {

    }

    /* METHODS */

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

        // System.out.println(sort(generatePtsLogMap()));
    }

    public void presentStandingTableSorted() {

        System.out.println("| TEAM | GOALS | V | S | D | PTS ");
        for (Teams team : sort(generatePtsLogMap())) {
            System.out.println(
                    StringPresentation.teamFormatter(team.getName()) +
                            StringPresentation.goalMapFormatter(goalsLogMap.get(team)) +
                            StringPresentation.victoryMapFormatter(victoryLogMap.get(team)) +
                            StringPresentation.stalemateMapFormatter(stalemateLogMap.get(team)) +
                            StringPresentation.defeatMapFormatter(defeatLogMap.get(team)) +
                            StringPresentation.pointCalculationAndPresentation(victoryLogMap.get(team),
                                    stalemateLogMap.get(team)));
        }

        // System.out.println(sort(generatePtsLogMap()));
    }

    public void topScorersUnsorted() {

        HashMap<AbstractPlayer, ArrayList<Score>> topScorerLog = generateTopScorerLog();
        

        System.out.println("PLAYER | TEAM | GOALS |");
        for (Map.Entry<AbstractPlayer, ArrayList<Score>> entry : topScorerLog.entrySet()){
            if(entry.getValue().size() != 0)
            System.out.println(entry.getKey().getName() + " " + entry.getValue().size());
        }


    }

    public void topScorerSorted(){
        HashMap<AbstractPlayer, ArrayList<Score>> topScorerLog = generateTopScorerLog();

        System.out.println(sortPlayer(topScorerLog));
        System.out.println("\n");

        
        for (AbstractPlayer player : sortPlayer(topScorerLog)) {
            System.out.println(player.getName() + " " + topScorerLog.get(player).size());
        }
    }
    
    private ArrayList<AbstractPlayer> sortPlayer(HashMap<AbstractPlayer, ArrayList<Score>> topScorerLog) {

        System.out.println("size: " + topScorerLog.values().size());
        List<Integer> topScorerByPts = new ArrayList<>(topScorerLog.values().size());

        System.out.println("list: " + topScorerByPts);
        Collections.sort(topScorerByPts, Collections.reverseOrder());

        // System.out.println(teamsByPts);

        return new ArrayList<AbstractPlayer>() {
            {
                for (int i = 0; i < topScorerByPts.size(); i++) {
                    for (Map.Entry<AbstractPlayer, ArrayList<Score>> key : topScorerLog.entrySet()) {
                        if (Objects.equals(topScorerByPts.get(i), key.getValue().size())) {
                            add(key.getKey());

                        }
                    }
                }
            }
        };
    }

    private HashMap<AbstractPlayer, ArrayList<Score>> generateTopScorerLog() {
        return new HashMap<AbstractPlayer, ArrayList<Score>>() {
            {
                for (int i = 0; i < getTeamList().size(); i++) {
                    for (AbstractPlayer player : teamList.get(i).getListOfPlayers()) {
                        put(player, new ArrayList<Score>() {
                            {
                                for (int i = 0; i < getTeamList().size(); i++) {
                                    for (int j = 0; j < goalsLogMap.size(); j++) {
                                        for (Score goal : goalsLogMap.get(getTeamList().get(i))) {
                                            if (goal.getScorer() == player) {
                                                add(goal);
                                            }
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            }
        };
    }

    /*
     * GENERATES A POINTS MAP BASED ON VICTORIES AND STALEMATES
     * THIS MAP IS LATER USED TO SORT OTHER MAPS BY POINTS
     */
    private HashMap<Teams, Integer> generatePtsLogMap() {
        return new HashMap<Teams, Integer>() {
            {
                for (Teams team : teamList) {
                    put(team, victoryLogMap.get(team) * 3 + stalemateLogMap.get(team));
                }
            }
        };
    }

    /* RETURNS ArrayList<Teams> SORTED BY POINTS */
    private ArrayList<Teams> sort(HashMap<Teams, Integer> ptsLogMap) {

        List<Integer> teamsByPts = new ArrayList<>(ptsLogMap.values());

        Collections.sort(teamsByPts, Collections.reverseOrder());

        // System.out.println(teamsByPts);

        return new ArrayList<Teams>() {
            {
                for (int i = 0; i < teamsByPts.size(); i++) {
                    for (Map.Entry<Teams, Integer> key : ptsLogMap.entrySet()) {
                        if (Objects.equals(teamsByPts.get(i), key.getValue())) {
                            add(key.getKey());
                            continue;
                        }
                    }
                }
            }
        };
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

    /* RETURNS ARRAYLIST WITH ALL GOALS PER TEAM */
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

    /*
     * WE PROVIDE ARRAYLIST OF ALL THE GOALS PER TEAM TO AN HASHMAP
     * TO BUILD A TABLE
     */
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
