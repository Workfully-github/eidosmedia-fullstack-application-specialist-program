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

    /* GENERATE FOOTBALL MATCH */
    public FootballMatch generateFootballMatch(Teams homeTeam, Teams awayTeam, String location) {

        return new FootballMatch(new ArrayList<Teams>() {
            {
                add(homeTeam);
                add(awayTeam);
            }
        }, location);
    }

    /* METHODS */

    public void playAllMatches(){
        for (int i = 0; i < teamList.size(); i++) {
            for (int j = 0; j < teamList.size()-1; j++) {
                Teams homeTeam = teamList.get(i);
                Teams awayTeam = teamList.get(j);
                if(i != j)
                playFootballMatch(homeTeam, awayTeam);
            }
            
        }
    }

    public void playFootballMatch(Teams homeTeam, Teams awayTeam){
        populateStandingTable(generateFootballMatch(homeTeam, awayTeam, "London"));
    }

    private void populateStandingTable(FootballMatch footballMatch){

        for (int i = 0; i < teamList.size(); i++) {
            for (int j = 1; j < teamList.size(); j++) {
                Teams homeTeam = teamList.get(i);
                Teams awayTeam = teamList.get(j);

                goalsLogMap.put(teamList.get(i), getScoreMapfromMatch(footballMatch, teamList.get(i)));
                goalsLogMap.put(teamList.get(j), getScoreMapfromMatch(footballMatch, teamList.get(j)));

                int homeTeamGoals = getScoreMapfromMatch(footballMatch, teamList.get(i)).size();
                int awayTeamGoals = getScoreMapfromMatch(footballMatch, teamList.get(j)).size();

                if(homeTeamGoals > awayTeamGoals){
                    victoryLogMap.put(homeTeam, +1);
                    defeatLogMap.put(awayTeam, +1);
                }

                if(homeTeamGoals < awayTeamGoals){
                    victoryLogMap.put(awayTeam, +1);
                    defeatLogMap.put(homeTeam, +1);
                }

                if(homeTeamGoals == awayTeamGoals){
                    stalemateLogMap.put(homeTeam, +1);
                    stalemateLogMap.put(awayTeam, +1);
        
                }
            }

        }
    }


    private ArrayList<Score> getScoreMapfromMatch(FootballMatch footballMatch, Teams team){
        return footballMatch.getScoreMap().get(team);
    }

    /*
     * GENERATE EVERY POSSIBLE FOOTBALL MATCH FOR WHOLE LEAGUE
     * MATCHES WILL BE AUTOMATICALLY PLAYED
     * GOALS WILL BE CALCULATED RANDOMLY ON EVERY MATCH AND WINNER DECLARED
     * IT IS POSSIBLE TO GENERATE STALEMATES
     * CHECK OUTPUT IN SANDBOX FOR BETTER UNDERSTANDING
     */
    public void generateAllFootballMatchesForThisLeague() {
        for (int i = 0; i < getTeamList().size(); i++) {
            for (int j = 1; j < getTeamList().size(); j++) {
                footballMatchesLogMap.add(generateFootballMatch(getTeamList().get(i), getTeamList().get(j), null));
            }
        }

        calculateGoalMap();
    }

    private void calculateGoalMap() {
        for (int i = 0; i < teamList.size(); i++) {
            for (int j = 0; j < teamList.size(); j++) {
                goalsLogMap.put(teamList.get(i), footballMatchesLogMap.get(j).getTeamsList().get(i).getScore());
            }

        }
    }

    /* GETTERS */
    public ArrayList<Teams> getTeamList() {
        return teamList;
    }

}
