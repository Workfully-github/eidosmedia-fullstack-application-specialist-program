public class CheckingAccount {
    
    private int balance, id;
    private String name;
    private int [] transactions;

    public CheckingAccount(int id, int balance, String name) {
        this.id = id;
        this.balance = balance;
        this.name = name;
    }

    public CheckingAccount(int id, String name, int[] transactions) {
        this.id = id;
        this.name = name;
        this.transactions = transactions;
    }


    public int getBalance() {
        for (int i = 0; i < transactions.length; i++) {
            balance += transactions[i];
        }
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
