public class MyBalance {
    
    public static void main (String[] args) {
        double balance = 1452.75;
        int month_expense = 750;
        int shirt = 15;

        if (month_expense > balance) {
            System.out.println("I can't pay my bills!!");
        } else {
            balance -= month_expense;
            if (shirt < balance) {
                System.out.println("We have enough! Yey!");
                balance -= shirt;
            } else {
                System.out.println("Maybe next month...");
            }
    
            System.out.println("My balance after expenses is: " + balance + "$");
        }

    }
}
