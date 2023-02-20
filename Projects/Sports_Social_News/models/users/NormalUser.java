package Projects.Sports_Social_News.models.users;

public class NormalUser extends User {

    private String creditCard;
    private boolean isPremium;
    
    public NormalUser(String username, String firstName, String lastName, boolean isPremium) {
        super(username, firstName, lastName);
        this.isPremium = isPremium;
    }

    public NormalUser(String username, String firstName, String lastName, boolean isPremium, String creditCard) {
        super(username, firstName, lastName);
        this.creditCard = creditCard;
        this.isPremium = isPremium;
    }

    public boolean isPremium() {return isPremium;}
}
