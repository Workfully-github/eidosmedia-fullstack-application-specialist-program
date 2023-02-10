package BankExercise;

import java.util.ArrayList;

public class CheckingAccount {

    private String name;
    private float balance;
    private int id;
    private static int counter = 0;

    private ArrayList<Float> transactionList;

    
    
    public CheckingAccount(String name) {
        this.name = name;
        this.balance = 0;
        this.id = counter++;
        this.transactionList = new ArrayList<>();
    }

    public void calculateTransactionList(){
        float transactionListBalance = 0;
        for (Float value : transactionList) {
            transactionListBalance += value;
        }
        System.out.println("The total amount of the Transaction List is: " + transactionListBalance);
        System.out.println("Calculating now... ");

        if(transactionListBalance < balance){
            System.out.println("You don't have enough money to pay your balance is: " + getBalance());
            return;
        }

        balance += transactionListBalance;

        System.out.println("Here is your account status.");
        System.out.println(toString());



    }

    public float getBalance() {
        return balance;
    }

    public void transaction(float value){
        transactionList.add(value);
    }

    public void deposit(float value){
        if(value > 0){
            this.balance += value;
        }
    }

    public void withdraw(float value){
        if(value < this.balance){
            this.balance -= value;
        }
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "\nCheckingAccount \nname=" + name + ", \nbalance=" + balance + ", \nid=" + id + "\n-----------------";
    }

    
    
}
