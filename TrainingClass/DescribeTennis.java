public class DescribeTennis {
    
    public TennisMatch Wimbledon;
    public Tennis tennis;

    public static void main(String[] args) {
        
        Tennis tennis = new Tennis();
        Player federer = new Player("Federer", 0, 20000, 123456789);
        Player nadal = new Player("Nadal", 100, 200, 12789);
        //TennisMatch match1 = new TennisMatch(federer, nadal, "Wimbledon", "20-17", "Federer", 120);

        /* match1.findWinner();
        tennis.printInfo();
        match1.describeGame(); */
    }
}
