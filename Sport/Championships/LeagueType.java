package Sport.Championships;

public enum LeagueType {

    NATIONALLEAGUE("National League");

    private String leagueType;

    LeagueType(String leagueType){
        this.leagueType = leagueType;
    }

    public String getLeagueType() {
        return leagueType;
    }

    
    
}
