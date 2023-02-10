package Excercise10_02.BankAccount;

public class CheckingAccount {
    private String name;
    private double balance;
    private int id;
    private double[] transactions;

    public CheckingAccount(String name, double[] transactions, int id) {
        this.name = name;
        this.transactions = transactions;
        this.id = id;
        this.balance = sum(transactions);
    }

    public double sum(double[] values){
        double sum = 0.;
        for(int i=0;i<values.length;i++){
            sum += values[i];
        }
        if(sum < 0){
            return 0;
        }
        return sum;
    }
    public double getBalance() {
        return balance;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CheckingAccount [name=" + name + ", balance=" + balance + ", id=" + id + "]";
    }

    

    
}
