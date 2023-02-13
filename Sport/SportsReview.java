public class SportsReview {
    public static void main(String[] args) {
        Sport soccer = new Soccer();
        Sport bascketBall = new BascketBall();
        Sport tennis = new Tennis();
        Sport golf = new Golf();

        Sport[] sports = {soccer, bascketBall, tennis, golf};

        for(int i = 0; i < sports.length; i++){
            sports[i].printInfo();
        }

        
    }
}
