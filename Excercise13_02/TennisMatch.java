package Excercise13_02;

public class TennisMatch extends Tennis {
    protected Player player1;
    protected Player player2;
    protected Player winner;
    protected String thePlace;
    protected String date;
    protected int player1IsPoints1;
    protected int player1IsPoints2;
    protected int duration;

    public TennisMatch(Player player1, Player player2, String thePlace, String date, int player1IsPoints1,
            int player1IsPoints2, int duration) {
        this.player1 = player1;
        this.player2 = player2;
        this.thePlace = thePlace;
        this.date = date;
        this.player1IsPoints1 = player1IsPoints1;
        this.player1IsPoints2 = player1IsPoints2;
        this.duration = duration;
        this.winner = this.winner();
    }

    public Player winner(){
        if(this.player1IsPoints1 > this.player1IsPoints2){
            player1.nb_win += 1 ;
            return this.player1;
        }
        else if(this.player1IsPoints1 < this.player1IsPoints2){
            return player2;
        }
        else {
            return null;
        }
    }

    public String printMacthInfo() {
        return name + " Match :" + player1.name + " " + player1IsPoints1 + " - " + player1IsPoints2 + " " + player2.name + "\n" + date;
    }
    
    
}
