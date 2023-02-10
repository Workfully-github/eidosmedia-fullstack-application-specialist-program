import java.util.HashMap;

public class Bank{
    
    private ChackingAccount accountOne;


    public Bank(){
        //Assuming the account holder must do an initial transaction to
        //activate the account:
        HashMap<String, Double>activationTransaction = new HashMap<String, Double>();
        activationTransaction.put("activation deposit", 400.0);
        this.accountOne = new ChackingAccount("Abderraouf", activationTransaction, 0);
    }

    public static void main(String[] args) {
        
        Bank twoCheckingAccounts = new Bank();
        //Adding some transactions
    
        twoCheckingAccounts.accountOne.setBalance("T-shirt", -55.0);
        twoCheckingAccounts.accountOne.setBalance("Payroll", -655.0);
        twoCheckingAccounts.accountOne.setBalance("Bonus", 55.0);
       
        System.out.println("Your account balance is: " + twoCheckingAccounts.accountOne.getBalance()[0] + " euro.\n  Here's your history of transactions: " +  twoCheckingAccounts.accountOne.getBalance()[1]);
    }
}