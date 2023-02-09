public class MyBalance {
    public static void main(String[] args) {
         double balance = 1452.75;
         double monthExp = 750;
         double tShirtCost = 15;
         
         balance -= monthExp;

         if(tShirtCost < balance){
            balance -= tShirtCost;
        System.out.println("you bought a t-shirt and your balance is:" + balance);

         }else{
             System.out.println("Your Balance is: $" + balance + ", and you don't have money for a new t-shirt");
         }


    }
}
