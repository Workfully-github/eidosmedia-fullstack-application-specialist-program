package Controller.ContentControllers;

import Model.Content.Text;
import Model.Users.Author;

public class CreateTextPostController {
    public static Text createText(Author author, String textBody, String coverImage, Boolean isPremiumContent) throws NullPointerException {
        if(textBody.isEmpty() || coverImage.isEmpty()) return null;
        Text newText = new Text(author, isPremiumContent, textBody, coverImage);
        author.addContent(newText);
        return newText;
    }
}
