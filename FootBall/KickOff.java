import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class KickOff {
    //Players for the
    static FootBallMatch FcPort_Sporting;
    static Team fcPorto;
    static Team sporting;
    static Team team_A;
    static Team team_B;

    static ArrayList<Player>fcPortoPlayers;
    static ArrayList<Player>sportingPlayers;
    static ArrayList<Player>team_A_Players;
    static ArrayList<Player>team_B_Players;

    //Player of FC PORTO
    
    public static void main(String[] args) {
            //Defining Players for FC PORTO
            Player diagoCosta = new Player("Diago Costa", "GK", fcPorto);
            Player fabioCardoso = new Player("Fabio Cardoso", "CB", fcPorto);
            Player pepe = new Player("Pepe", "CB", fcPorto);
            Player zaidu = new Player("Zaidu", "LB", fcPorto);
            Player joaoMario = new Player("Joao Mario", "RB", fcPorto);
            Player matieusUribe = new Player("Matieus Uribe", "DM", fcPorto);
            Player marko = new Player("Marko", "DM", fcPorto);
            Player stephan = new Player("Stephan", "CM", fcPorto);
            Player gabriel = new Player("Gabriel", "LW", fcPorto);
            Player goncalo = new Player("Goncalo", "RW", fcPorto);
            Player mehdi = new Player("Mehdi", "CF", fcPorto);

            fcPortoPlayers = new ArrayList<Player>();
            fcPortoPlayers.add(diagoCosta);
            fcPortoPlayers.add(fabioCardoso);
            fcPortoPlayers.add(pepe);
            fcPortoPlayers.add(zaidu);
            fcPortoPlayers.add(joaoMario);
            fcPortoPlayers.add(matieusUribe);
            fcPortoPlayers.add(marko);
            fcPortoPlayers.add(stephan);
            fcPortoPlayers.add(gabriel);
            fcPortoPlayers.add(goncalo);
            fcPortoPlayers.add(mehdi);

            //Defining Players for Sporting
            Player adan = new Player("Adan", "GK", sporting);
            Player coates = new Player("Coates", "CB", sporting);
            Player juste = new Player("Juste", "CB", sporting);
            Player nazinho = new Player("Nazinho", "LB", sporting);
            Player esgaio = new Player("Esgaio", "RB", sporting);
            Player tanlongo = new Player("Tanlongo", "DM", sporting);
            Player eduardo = new Player("Eduardo", "DM", sporting);
            Player braganca = new Player("Braganca", "CM", sporting);
            Player santos = new Player("Santos", "LW", sporting);
            Player fatawu = new Player("Fatawu", "RW", sporting);
            Player paulinho = new Player("Paulinho", "CF", sporting);

            sportingPlayers = new ArrayList<Player>();

            sportingPlayers.add(adan);
            sportingPlayers.add(coates);
            sportingPlayers.add(juste);
            sportingPlayers.add(nazinho);
            sportingPlayers.add(esgaio);
            sportingPlayers.add(tanlongo);
            sportingPlayers.add(eduardo);
            sportingPlayers.add(braganca);
            sportingPlayers.add(santos);
            sportingPlayers.add(fatawu);
            sportingPlayers.add(paulinho);

            //Iniating the oponents teams
            fcPorto = new Team("FC Porto", "Sérgio Conceição",fcPortoPlayers);
            sporting = new Team("Sporting", "Amorim",sportingPlayers);
            
            //Initiating team A & B
            team_A_Players = new ArrayList<>();
            team_B_Players = new ArrayList<>();
            for(int i = 0; i < 11; i++){
                team_A_Players.add(new Player("player_A_" + i, "SM", team_A));
                team_B_Players.add(new Player("player_B_" + i, "SM", team_B));
            }

            team_A = new Team("Team A", "Abdu", team_A_Players);
            team_B = new Team("Team B", "Ricardo", team_B_Players);


            //Initiating the League
            League portugueseLeague = new League("Portuguese");
            int matchs = 0;
            Scanner userInput = new Scanner(System.in);
            ArrayList<Team>opponents = new ArrayList<Team>();
            opponents.add(fcPorto);
            opponents.add(sporting);
            opponents.add(team_A);
            // opponents.add(team_B);

            int firstTeamIndex = 5;

        while(matchs < 2){
            System.out.println("Welcom to Match #" + (matchs + 1) + " in the " + portugueseLeague.getLeagueName() + " League.");
            System.out.println("Choose two teams, please:\n");

            for(int i = 0; i < 2 ; i++){
                System.out.println("Enter team #" + (i + 1));
                    for(int chosenTeam = 0; chosenTeam < opponents.size() ; chosenTeam++){
                        if(firstTeamIndex == chosenTeam) continue;
                        System.out.println(chosenTeam + " --> " + opponents.get(chosenTeam).teamName);
                    }
                    firstTeamIndex = userInput.nextInt();
                    portugueseLeague.setCurrentMatchTeams(opponents.get(firstTeamIndex));


            }
            firstTeamIndex = 5;
            //Check if this match was already played
            if (portugueseLeague.isLeagueMatchExist(portugueseLeague.getCurrentMatchTeams(0), portugueseLeague.getCurrentMatchTeams(1))){
                System.out.println("You already played this Match, try again");
                matchs--;
                continue;
            }

            portugueseLeague.setLeagueMatchs(portugueseLeague.getCurrentMatchTeams(0), portugueseLeague.getCurrentMatchTeams(0));


            

            FcPort_Sporting = new FootBallMatch(portugueseLeague.getCurrentMatchTeams(), "Estadio do Dragao", "Liga Portugal");
            portugueseLeague.getCurrentMatchTeams(0).lineUp();
            portugueseLeague.getCurrentMatchTeams(1).lineUp();

            ArrayList<Player>matchScorers = new ArrayList<Player>();

            boolean isTimeEnd = false;
            //User Input for eache match
            while(!isTimeEnd) {
                System.out.println("Enter the Team Index you want to start playing with:\n" + "0--> " + portugueseLeague.getCurrentMatchTeams().get(0).teamName +"\n1--> " + portugueseLeague.getCurrentMatchTeams().get(1).teamName);
                int teamIndex = userInput.nextInt();

                System.out.println("\nEnter index of the player who scored:");
                for(int i = 0; i < portugueseLeague.getCurrentMatchTeams().get(teamIndex).players.size(); i++){
                    System.out.println(i + " --> " + portugueseLeague.getCurrentMatchTeams().get(teamIndex).players.get(i).playerName);
                }
                int playerIndex = userInput.nextInt();

                //a player score
                portugueseLeague
                .getCurrentMatchTeams()
                .get(teamIndex)
                .players
                .get(playerIndex)
                .scored();
                
                //Team Goals updats
                portugueseLeague
                .getCurrentMatchTeams()
                .get(teamIndex)
                .setGoals(portugueseLeague
                .getCurrentMatchTeams()
                .get(teamIndex)
                .players
                .get(playerIndex)
                .getGoalsScored());

                matchScorers.add(portugueseLeague.getCurrentMatchTeams().get(teamIndex).players.get(playerIndex));

                
                
                System.out.println("Did the referee ended the match yet?");
                isTimeEnd = userInput.nextBoolean();
            }
            //Update Team Stats (Wins, Losses, nulls)
            if(portugueseLeague.getCurrentMatchTeams().get(0).getGoals() > portugueseLeague.getCurrentMatchTeams().get(1).getGoals()){
                portugueseLeague.getCurrentMatchTeams().get(0).setWins();
                portugueseLeague.getCurrentMatchTeams().get(1).setLosses();
            }else if(portugueseLeague.getCurrentMatchTeams().get(0).getGoals() < portugueseLeague.getCurrentMatchTeams().get(1).getGoals()){
                portugueseLeague.getCurrentMatchTeams().get(1).setWins();
                portugueseLeague.getCurrentMatchTeams().get(0).setLosses();
            }else {
                portugueseLeague.getCurrentMatchTeams().get(1).setNulls();
                portugueseLeague.getCurrentMatchTeams().get(0).setNulls();

            }

            firstTeamIndex = 50;
            
            FcPort_Sporting.setScorers(matchScorers);


        
            System.out.println(FcPort_Sporting.getFinaleScore());
            portugueseLeague.setLeagueMatchs(portugueseLeague.getCurrentMatchTeams(0), portugueseLeague.getCurrentMatchTeams(0));
            portugueseLeague.cleanCurrentMatchTeams();
            // FcPort_Sporting.getMoM();
            System.out.println("\nTanks for watching, see you next time folks!");
            matchs++;
        }
        
        portugueseLeague.getLeagueStanding(opponents);

    }
}
