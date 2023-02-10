package Excercise10_02.BankAccount;

public class Bank {
    private CheckingAccount account1;
    private CheckingAccount account2;

    public Bank(CheckingAccount account1, CheckingAccount account2) {
        this.account1 = account1;
        this.account2 = account2;
    }

    public Bank(CheckingAccount account1) {
        this.account1 = account1;
    }

    public static void main(String[] args) {
        double[] transaction1 = {0., -99., 8.03};
        double[] transaction2 = {7., 3.88, -5.03};
        CheckingAccount account1 = new CheckingAccount("Ali", transaction1  , 0);
        CheckingAccount account2 = new CheckingAccount("David", transaction2, 0);
        Bank Bank_instance = new Bank(account1, account2);
        
        System.out.println(" the first account is : \n" + Bank_instance.account1.toString());
        System.out.println(" the second account is : \n" + Bank_instance.account2.toString());

    }
    
}
