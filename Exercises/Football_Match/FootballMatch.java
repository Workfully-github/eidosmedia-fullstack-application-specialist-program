package Football_Match;

import java.util.ArrayList;
import java.util.HashMap;

public class FootballMatch {
    public ArrayList<FootballPlayers> playersTeamA = new ArrayList();
    public ArrayList<FootballPlayers> playersTeamB = new ArrayList();
    public HashMap<FootballTeams, Integer> score = new HashMap<FootballTeams, Integer>();
    public HashMap<FootballPlayers, Integer> scorersTeamA = new HashMap<FootballPlayers, Integer>();
    public HashMap<FootballPlayers, Integer> scorersTeamB = new HashMap<FootballPlayers, Integer>();
    public HashMap<FootballPlayers, Integer> ratingsTeamA = new HashMap<FootballPlayers, Integer>();
    public HashMap<FootballPlayers, Integer> ratingsTeamB = new HashMap<FootballPlayers, Integer>();
    public ArrayList<FootballPlayers> lineupTeamA = new ArrayList<>();
    public ArrayList<FootballPlayers> lineupTeamB = new ArrayList<>();
    public ArrayList<FootballTeams> teams = new ArrayList<>();
    public FootballTeams winner;

    public FootballMatch(ArrayList<FootballPlayers> playersTeamA, ArrayList<FootballPlayers> playersTeamB,
    HashMap<FootballTeams, Integer> score, HashMap<FootballPlayers, Integer> ratingsTeamA,
    HashMap<FootballPlayers, Integer> ratingsTeamB, ArrayList<FootballPlayers> lineupTeamA,
    ArrayList<FootballPlayers> lineupTeamB, ArrayList<FootballTeams> teams,
    HashMap<FootballPlayers, Integer> scorersTeamA, HashMap<FootballPlayers, Integer> scorersTeamB,
    FootballTeams winner) {
        this.playersTeamA = playersTeamA;
        this.playersTeamB = playersTeamB;
        this.score = score;
        this.ratingsTeamA = ratingsTeamA;
        this.ratingsTeamB = ratingsTeamB;
        this.lineupTeamA = lineupTeamA;
        this.lineupTeamB = lineupTeamB;
        this.teams = teams;
        this.scorersTeamA = scorersTeamA;
        this.scorersTeamB = scorersTeamB;
        this.winner = winner;
    }

    public void showMatchInfo() {
        System.out.println("This game was " + teams.get(0).name + " VS " + teams.get(1).name);
        System.out.println("The winner was " + getMatchWinner().name + " by " + getScore());
        /* System.out.println("The man of the match was " + mvp); */
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
        } else if (score.get(teams.get(0)) < score.get(teams.get(1))) {
            winner = teams.get(1);
            teams.get(1).wins ++;
            teams.get(1).goalsScored = score.get(teams.get(1));
            teams.get(1).goalsConceded = score.get(teams.get(0));
        } /* else {
            FootballTeams drawTeam = new FootballTeams();
            winner = drawTeam;
        } */
        return winner;
    }

    public void getLineups() {
        System.out.println(teams.get(0).name + " lineup is: ");
        for (FootballPlayers lineupA : lineupTeamA) {
            System.out.println(lineupA.name + " ");
        }

        System.out.println(teams.get(1).name + " lineup is: ");
        for (FootballPlayers lineupB : lineupTeamB) {
            System.out.println(lineupB.name + " ");
        }
    }

    public void getScorers() {
        if (!(scorersTeamA.isEmpty())) {
            System.out.println(teams.get(0).name + " scorers are: ");
            for (HashMap.Entry<FootballPlayers, Integer> goals : scorersTeamA.entrySet()) {
                System.out.println(goals.getKey().name + " scored " + goals.getValue());
            }
        } else {
            System.out.println("No goals from " + teams.get(0).name);
        }

        if (!(scorersTeamB.isEmpty())) {
            System.out.println(teams.get(1).name + " scorers are: ");
            for (HashMap.Entry<FootballPlayers, Integer> goals : scorersTeamB.entrySet()) {
                System.out.println(goals.getKey().name + " scored " + goals.getValue());
            }
        } else {
            System.out.println("No goals from " + teams.get(1).name);
        }
    }

    public void getRating() {
        System.out.println("RATINGS:");
        System.out.println("Team A");
        for (HashMap.Entry<FootballPlayers, Integer> rating : ratingsTeamA.entrySet()) {
                System.out.println(rating.getKey().name + " had a rating of " + rating.getValue());
            }
        
        System.out.println("Team B");
        for (HashMap.Entry<FootballPlayers, Integer> rating : ratingsTeamB.entrySet()) {
                System.out.println(rating.getKey().name + " had a rating of " + rating.getValue());
            }
            
    }

/*     public FootballPlayers getMVP() {
        
        // HashMap<FootballPlayers, Double> ratingsTeamA

        return "";
    } */
}
