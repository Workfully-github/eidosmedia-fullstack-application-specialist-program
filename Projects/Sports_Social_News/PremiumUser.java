package Projects.Sports_Social_News;

public class PremiumUser extends User {

    private String creditCard;
    
    public PremiumUser(String name, int age, String email) {
        super(name, age, email);
    }

    public PremiumUser(String name, int age, String email, String creditCard) {
        super(name, age, email);
        this.creditCard = creditCard;
    }
}
