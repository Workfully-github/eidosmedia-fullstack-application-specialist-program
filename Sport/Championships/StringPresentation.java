package Sport.Championships;

import java.util.ArrayList;

import Sport.Scores.Goal;

public class StringPresentation {

    public static String teamFormatter(String string){

        return string.length() > 8 ? string.substring(0, 8) : string + " ".repeat(8 - string.length());
    }

    public static String goalMapFormatter(ArrayList<Goal> goalList){
        return goalList.size() > 9 ? " ".repeat(3) + goalList.size() + " ".repeat(3) : " ".repeat(3) + goalList.size() + " ".repeat(3);
    }
    
    public static String victoryMapFormatter(Integer victoryAmount){
        return victoryAmount > 9 ? " ".repeat(1) + victoryAmount + " ".repeat(1) : " ".repeat(2) + victoryAmount + " ".repeat(1);
    }

    public static String stalemateMapFormatter(Integer stalemateAmount){
        return stalemateAmount > 9 ? " ".repeat(1) + stalemateAmount + " ".repeat(1) : " ".repeat(2) + stalemateAmount + " ".repeat(1);
    }

    public static String defeatMapFormatter(Integer defeatAmount){
        return defeatAmount > 9 ? " ".repeat(1) + defeatAmount + " ".repeat(1) : " ".repeat(2) + defeatAmount + " ".repeat(1);
    }

    public static String pointCalculationAndPresentation(Integer victoryAmount, Integer stalemateAmount){

        return victoryAmount * 3 + stalemateAmount > 9 ? " ".repeat(1) + "0" + Integer.toString(victoryAmount * 3 + stalemateAmount) : " ".repeat(3) + Integer.toString(victoryAmount * 3 + stalemateAmount);
    }
}
