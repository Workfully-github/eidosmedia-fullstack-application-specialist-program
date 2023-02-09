package MyBalance;
public class MyBalance {
    private Double balance;
    public MyBalance(Double balance) {
        this.balance = balance;
    }

    public Double update(Double thisMonthExpenses){
        this.balance -= thisMonthExpenses;
        return this.balance; 
    }

    public Double BuyAndUpdate(Double price){
        if(this.balance >= price){
            System.out.println("the price is less than the balance");
            this.balance -= price;
        }else{
            System.out.println("the price is more than the balance");
        }
        return this.balance; 
    }

    @Override
    public String toString() {
        return "MyBalance [balance=" + balance + "]";
    }

    public static void main(String[] args) {
        Double price = 15.;
        MyBalance myBalance = new MyBalance(1452.75);
        
        System.out.println(myBalance.BuyAndUpdate(price));


    }
    
    
    
}
