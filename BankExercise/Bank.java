package BankExercise;

import java.util.ArrayList;

public class Bank {

    //private CheckingAccount accountOne;
    //private CheckingAccount accountTwo;

    private ArrayList<CheckingAccount> checkingAccountLocalDataBase = new ArrayList<>();

    public Bank(){

    }

    public Bank(CheckingAccount checkingAccount){
        this.checkingAccountLocalDataBase.add(checkingAccount);
    }


    public void createTwoAccounts(String accountNameOne, String accountNameTwo){
        checkingAccountLocalDataBase.add(new CheckingAccount(accountNameOne));
        checkingAccountLocalDataBase.add(new CheckingAccount(accountNameTwo));
    }

    public void createAccount(String accountname){
        checkingAccountLocalDataBase.add(new CheckingAccount(accountname));
    }

    public String getAccountInfo(int id){
        return checkingAccountLocalDataBase.get(id).toString();
    }

    public CheckingAccount getAccount(int id){
        return checkingAccountLocalDataBase.get(id);
    }
    public static void main(String[] args) {

        /* BANK INSTANTIATION */
        Bank bank = new Bank();

        /* Bank 1 OPERATIONS */
        bank.createAccount("Hugo");

        System.out.println(bank.getAccountInfo(0));

        bank.getAccount(0).transaction(-20);
        bank.getAccount(0).transaction(40);
        
        bank.getAccount(0).calculateTransactionList();

        /* Bank 2 OPERATIONS */
       

    }
    
    
}
