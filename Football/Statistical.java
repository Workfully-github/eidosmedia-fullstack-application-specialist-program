import java.util.ArrayList;
import java.util.HashMap;

public abstract class Statistical {
	
    private HashMap<FootballPlayer,Integer> scorers = new HashMap<FootballPlayer,Integer>();

	
	
	
	public String getTopScorers(){
		
		return "Best scorer is "+ scorers.get(0);
	}

}
