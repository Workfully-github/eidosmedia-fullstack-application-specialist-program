import java.util.HashMap;

public class ChackingAccount {
    private String name;
    private HashMap<String, Double>transactionsArr;
    private double balance;
    private int id;

 
    
    public ChackingAccount(String name, HashMap<String, Double>transactionsArr, int id){
        this.name = name;
        this.transactionsArr = transactionsArr;
        this.id = id;
        
        for (double transaction : this.transactionsArr.values()){
            this.balance = transaction;

        }


    }

    public Object[] getBalance(){
        this.balance = 0.0;

        for(String transaction : transactionsArr.keySet()){
            this.balance += transactionsArr.get(transaction); 
        }
        return new Object[] {this.balance, this.transactionsArr};
    }


    
    public void setBalance(String item, double price) {

        if(this.balance + price <= 0.0) {
            //We can either set the balance to 0.0 or we tell the account holder that
            //he can't make anymore transactions
            System.out.println("Alert!!! You don't have enough balance to make this transaction --> " + item + " : " + price + "euro!");
            return;
        }

        this.transactionsArr.put(item, price);
        this.balance += price; 
    }
}