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

        //nationalLeague.playAllMatches();

        //nationalLeague.playFootballMatch(nationalLeague.getTeamList().get(0), nationalLeague.getTeamList().get(1));
        //nationalLeague.playFootballMatch(nationalLeague.getTeamList().get(1), nationalLeague.getTeamList().get(0));
        
        nationalLeague.playAllMatches();


        

        nationalLeague.presentStandingTable();






    }
}