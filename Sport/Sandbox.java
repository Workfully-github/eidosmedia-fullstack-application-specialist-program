package Sport;

import Sport.Championships.League;
import Sport.Teams.Teams;

public class Sandbox {

    public static void main(String[] args) {

        /* TIP: COLLAPSE ALL METHODS FOR BETTER VIEW */

        /* BOOTSTRAPING VALUES */

        Bootstrap bootstrap = new Bootstrap();

        League nationalLeague = bootstrap.bootstrapInit();

        /* LEAGUE STANDING */
        nationalLeague.presentStandingTable();

        /* @see #generateAllFootballMatchesForThisLeague() */
        //nationalLeague.generateAllFootballMatchesForThisLeague();

        nationalLeague.populateGoalsLogMap();

        nationalLeague.presentStandingTable();






    }
}