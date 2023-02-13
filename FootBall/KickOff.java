import java.util.ArrayList;
import java.util.HashMap;

public class KickOff {
    //Players for the
    static FootBallMatch FcPort_Sporting;
    static Team fcPorto;
    static Team sporting;

    static ArrayList<Player>fcPortoPlayers;
    static ArrayList<Player>sportingPlayers;

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

        //Initiating the Match
        ArrayList<Team>opponents = new ArrayList<Team>();
        opponents.add(fcPorto);
        opponents.add(sporting);

        FcPort_Sporting = new FootBallMatch(opponents, "Estadio do Dragao", "Liga Portugal");
        fcPorto.lineUp();
        sporting.lineUp();

        //Describing the match from FC Porto Perspective

        gabriel.assissted();
        gabriel.assissted();
        goncalo.assissted();
        mehdi.scored();
        fcPorto.setGoals(mehdi.getGoalsScored());
        goncalo.assissted();
        gabriel.assissted();
        gabriel.assissted();
        gabriel.scored();
        fcPorto.setGoals(gabriel.getGoalsScored());

        ArrayList<Player>matchScorers = new ArrayList<Player>();
        matchScorers.add(mehdi);
        matchScorers.add(gabriel);


        // FcPort_Sporting.setScorers(fcPortoScorers);

        //Describing the match from Sporting Perspective

        braganca.assissted();
        braganca.assissted();
        santos.assissted();
        fatawu.scored();
        sporting.setGoals(fatawu.getGoalsScored());
        paulinho.assissted();
        braganca.assissted();

        matchScorers.add(fatawu);


        FcPort_Sporting.setScorers(matchScorers);


        // System.out.println(FcPort_Sporting.getFinaleScore());
        FcPort_Sporting.getScorers();
        System.out.println(FcPort_Sporting.getFinaleScore());
        FcPort_Sporting.getMoM();
        System.out.println("\nTanks for watching, see you next time folks!");
    }
}
