package Football_Match;

import java.util.ArrayList;
import java.util.HashMap;

public class FootballMatch {
    public ArrayList<FootballPlayers> playersTeamA = new ArrayList();
    public ArrayList<FootballPlayers> playersTeamB = new ArrayList();
    public HashMap<FootballTeams, Integer> score = new HashMap<FootballTeams, Integer>();
    public HashMap<FootballPlayers, Double> ratingsTeamA = new HashMap<FootballPlayers, Double>();
    public HashMap<FootballPlayers, Double> ratingsTeamB = new HashMap<FootballPlayers, Double>();
    public FootballPlayers mvp;
    public FootballTeams winner;
    public ArrayList<FootballPlayers> lineupTeamA = new ArrayList<>();
    public ArrayList<FootballPlayers> lineupTeamB = new ArrayList<>();
    public ArrayList<FootballTeams> teams = new ArrayList<>();

    public FootballMatch(ArrayList<FootballPlayers> playersTeamA, ArrayList<FootballPlayers> playersTeamB,
    HashMap<FootballTeams, Integer> score, HashMap<FootballPlayers, Double> ratingsTeamA,
    HashMap<FootballPlayers, Double> ratingsTeamB, FootballPlayers mvp,
    FootballTeams winner, ArrayList<FootballPlayers> lineupTeamA,
    ArrayList<FootballPlayers> lineupTeamB, ArrayList<FootballTeams> teams) {
        this.playersTeamA = playersTeamA;
        this.playersTeamB = playersTeamB;
        this.score = score;
        this.ratingsTeamA = ratingsTeamA;
        this.ratingsTeamB = ratingsTeamB;
        this.mvp = mvp;
        this.winner = winner;
        this.lineupTeamA = lineupTeamA;
        this.lineupTeamB = lineupTeamB;
        this.teams = teams;
    }

    public void showMatchInfo() {
        System.out.println("This game was " + teams.get(0).name + " VS " + teams.get(1).name);
        System.out.println("The winner was " + getMatchWinner() + "by " + getScore());
        System.out.println("The man of the match was " + mvp + "from " + mvp.team);
    }

    public String getScore() {
        String scoreTeamA = score.get(teams.get(0)).toString();
        String scoreTeamB = score.get(teams.get(1)).toString();
        String finalScore = scoreTeamA + " - " + scoreTeamB;
        return finalScore;
    }

    public FootballTeams getMatchWinner() {
        if(score.get(teams.get(0)) > score.get(teams.get(1))) {
            winner = teams.get(0);
            teams.get(0).wins ++;
            teams.get(0).goalsScored = score.get(teams.get(0));
            teams.get(0).goalsConceded = score.get(teams.get(1));
        } else {
            winner = teams.get(1);
            teams.get(1).wins ++;
            teams.get(1).goalsScored = score.get(teams.get(1));
            teams.get(1).goalsConceded = score.get(teams.get(0));
        }
        return winner;
    }

    public void getLineups() {

    }

    public void getScorers() {

    }

   /*  public FootballPlayers getMVP() {
        
        return "";
    } */
}
