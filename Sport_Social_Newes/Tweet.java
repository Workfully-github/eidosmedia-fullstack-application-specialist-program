public class Tweet extends Content {
    public Tweet (Author author, Boolean isPremiumContent, String textContent, int textContentLimit){
        super(author, isPremiumContent, textContent, 280);
    }
}
