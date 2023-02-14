package Football_Match;

import java.util.ArrayList;
import java.util.HashMap;

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
    }
}
