package Sport.Championships;

import java.util.ArrayList;

import Sport.Teams.Teams;

public class NationalLeague extends League{

    ArrayList<Teams> teamList;

    public NationalLeague(){
        
    }

    public NationalLeague(ArrayList<Teams> teamList){
        this.teamList = teamList;
    }

    
}
