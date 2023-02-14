package Excercise13And14_02.FootBall;

import Excercise13And14_02.Player;

public class Goal {
    Player scorer;
    int minute;
    Player assistant;
    
    public Goal(Player scorer, int minute, Player assistant) {
        this.scorer = scorer;
        this.minute = minute;
        this.assistant = assistant;
    }

    @Override
    public String toString() {
        return "Goal [scorer=" + scorer + ", minute=" + minute + ", assistant=" + assistant + "]";
    }

    
}
