package Football_Match;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class FootballMain {
    
    public static void main(String[] args) {

        // Team A
        ArrayList<FootballPlayers> playersTeamA = new ArrayList<>() {
            {
                add(new FootballPlayers("Amine"));
                add(new FootballPlayers("Abderraouf"));
                add(new FootballPlayers("Sidi"));
                add(new FootballPlayers("Ricardo"));
                add(new FootballPlayers("Hugo"));
                add(new FootballPlayers("Ronaldo"));
                add(new FootballPlayers("Messi"));
                add(new FootballPlayers("Mbappé"));
                add(new FootballPlayers("Neymar"));
                add(new FootballPlayers("João Félix"));
                add(new FootballPlayers("Bernardo Silva"));
            }
        };

        // Team B
        ArrayList<FootballPlayers> playersTeamB = new ArrayList<>() {
            {
                add(new FootballPlayers("Benzema"));
                add(new FootballPlayers("Modric"));
                add(new FootballPlayers("Bruno Fernandes"));
                add(new FootballPlayers("Vitinha"));
                add(new FootballPlayers("De Bruyne"));
                add(new FootballPlayers("Halaand"));
                add(new FootballPlayers("Havertz"));
                add(new FootballPlayers("Son"));
                add(new FootballPlayers("Kane"));
                add(new FootballPlayers("Salah"));
                add(new FootballPlayers("Mané"));
            }
        };

        // Introduce random rating for Team A
        // Try to add points to the players that score and to the team that wins the game!
        HashMap<FootballPlayers, Integer> ratingsTeamA = new HashMap<>() {
            {
                for (int i = 0; i < playersTeamA.size(); i ++ ) {
                    put(playersTeamA.get(i), (int) Math.floor((Math.random() * 10) + 1));
                }
            }
        };

        // Introduce random rating for Team B
        HashMap<FootballPlayers, Integer> ratingsTeamB = new HashMap<>() {
            {
                for (int i = 0; i < playersTeamB.size(); i ++ ) {
                    put(playersTeamB.get(i), (int) Math.floor((Math.random() * 10) + 1));
                }
            }
        };

        // Create Team A and Team B
        ArrayList<FootballTeams> teams = new ArrayList<>(){
            {
                add(new FootballTeams(playersTeamA, "Team A", "Porto", 22, 1, 45, 10));
                add(new FootballTeams(playersTeamB, "Team B", "Lisbon", 15, 2, 35, 20));
            }
        };

        // Create score
        HashMap<FootballTeams, Integer> score = new HashMap<FootballTeams, Integer>() {
            {
                for (int i = 0; i < teams.size(); i ++) {
                    put(teams.get(i), (int) Math.floor((Math.random() * 5) + 1));
                }
            }
        };

        // Scorers for Team A
        /* HashMap<FootballPlayers, Integer> scorersTeamA = new HashMap<FootballPlayers, Integer>() {
            {
                int numbGoals = get(teams.get(0));

                for (int i = 0; i < numbGoals; i ++) {
                    int randomPlayerIndex = (int) Math.floor((Math.random() * 5) + 1);
                    FootballPlayers randomPlayer = playersTeamA.get(randomPlayerIndex);
                    scorersTeamA.merge(randomPlayer, 1, Integer::sum);
                } 
                

            }
        }; 

        // Scorers for Team B
        /* HashMap<FootballPlayers, Integer> scorersTeamB = new HashMap<FootballPlayers, Integer>() {
            {
                int numbGoals = get(teams.get(1));

                for (int i = 0; i < numbGoals; i ++) {
                    int randomPlayerIndex = (int) Math.floor((Math.random() * 5) + 1);
                    FootballPlayers randomPlayer = playersTeamB.get(randomPlayerIndex);
                    scorersTeamB.merge(randomPlayer, 1, Integer::sum);
                } 
                

            }
        }; */

        ArrayList<FootballPlayers> lineupTeamA = playersTeamA;
        ArrayList<FootballPlayers> lineupTeamB = playersTeamB;

        FootballMatch match = new FootballMatch(playersTeamA, playersTeamB, score, ratingsTeamA, ratingsTeamB, lineupTeamA, lineupTeamB, teams, ratingsTeamA, ratingsTeamB, null);
        
/*         match.showMatchInfo();

        match.getLineups();

        match.getScorers(); 

        match.getRating();  */ 

    }
        ArrayList<FootballPlayers> playersTeamA = new ArrayList<>();

        
        //Goal goal1 = scoredGoal(playersTeamA.get(3), 35, playersTeamA.get(4));
        //Goal goal1 = scoredGoal(enterScorer(), enterMinute(), enterAssistant());



        /* private static Goal scoredGoal(FootballPlayers scorer, int minute) {
            scoredGoal(scorer, minute, null);
        } */
        private static Goal scoredGoal(FootballPlayers scorer, int minute, FootballPlayers assistant) {
            return new Goal(scorer, minute, assistant);
        }

        public String enterScorer() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the scorer of the goal - ");  
            String scorer = sc.nextLine();
            FootballPlayers goalScorer;

            return scorer; 
        }
        public int enterMinute() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the minute of the goal - ");  
            int minute = sc.nextInt();
            return minute;
        }
        public String enterAssistant() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the assistant - ");  
            String assistant = sc.nextLine();
            return assistant;
        }
    
}
