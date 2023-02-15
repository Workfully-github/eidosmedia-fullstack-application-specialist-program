package Sport;

import Sport.Championships.League;

public class Sandbox {

    public static void main(String[] args) {

        /* TIP: COLLAPSE ALL METHODS FOR BETTER VIEW */

        /* BOOTSTRAPING VALUES */

        Bootstrap bootstrap = new Bootstrap();

        League nationalLeague = bootstrap.bootstrapInit();

        /* RUN HERE */

        nationalLeague.presentStandingTable();
        
        nationalLeague.generateAllFootballMatchesForThisLeague();

        nationalLeague.presentStandingTable();

    }
}