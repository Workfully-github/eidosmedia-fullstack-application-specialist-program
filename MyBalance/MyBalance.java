public class MyBalance {

    // Properties

    public static double balance = 15;

    public static double monthlyExpenses = 1449;

    public static final double TSHIRTVALUE = 15;

    // Methods

    public static void showBalance() {
        System.out.println("Current Balance is: " + balance + " Euro");
    }

    public static void main(String[] args) {

        if(monthlyExpenses > balance) {

            System.out.println("You don't have enough money to pay your monthly expenses");
            return;

        }

        balance -= monthlyExpenses;

        showBalance();
    
        
        if(TSHIRTVALUE > balance) {

            System.out.println("Transaction refused.");
            return;

        }

        balance -= TSHIRTVALUE;

        System.out.println("You have bought a T-Shirt");

        showBalance();

    }
    
}
