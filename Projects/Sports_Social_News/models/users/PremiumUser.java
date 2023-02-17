package Projects.Sports_Social_News.models.users;

public class PremiumUser extends User {

    private String creditCard;
    
    public PremiumUser(String username, String firstName, String lastName) {
        super(username, firstName, lastName);
    }

    public PremiumUser(String username, String firstName, String lastName, String creditCard) {
        super(username, firstName, lastName);
        this.creditCard = creditCard;
    }
}
