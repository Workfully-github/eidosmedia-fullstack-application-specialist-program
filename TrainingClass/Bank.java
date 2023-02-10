public class Bank {
    
    private CheckingAccount accountOne, accountTwo;

    public Bank(){}
    
    public Bank(CheckingAccount accountOne) {
        this.accountOne = accountOne;
    }

    public void instantiateAccounts() {
        int[] transactionOne = {-7446, 6399, 1057, -8137, 10000};
        int[] transactionTwo = {74846, 699, 1057, 85137};
        accountOne = new CheckingAccount(12345, "Hugo", transactionOne);
        accountTwo = new CheckingAccount(67890, "Esteves", transactionTwo);
    }

    public static void main(String[] args) {
        Bank deutcheBank = new Bank();

        CheckingAccount santanderAccount = new CheckingAccount(3456, 123456, "wrgdfhbcvfd");
        Bank santander = new Bank(santanderAccount);

        deutcheBank.instantiateAccounts();

        System.out.println("Your final balance on accountOne is " + deutcheBank.accountOne.getBalance());
        System.out.println("Your final balance on accountTwo is " + deutcheBank.accountTwo.getBalance());

    }
}
