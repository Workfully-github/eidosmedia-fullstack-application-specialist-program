package org.workfully.models.content;

import java.util.ArrayList;
import org.workfully.models.reactions.AbstractReaction;
import org.workfully.models.users.AbstractUser;
import org.workfully.view.section.PostDetail;

public abstract class AbstractContent {

    /* PROPERTIES */
    private AbstractUser contentAuthor;
    private String textBody;
    private ArrayList<UserComment> commentLogMap;
    private ArrayList<AbstractReaction> reactionLogMap;
    private boolean premium;

    private PostDetail postDetail;

    /* CONSTRUCTOR */
    public AbstractContent(AbstractUser contentAuthor, String textBody) {
        this.contentAuthor = contentAuthor;
        this.textBody = textBody;
        this.commentLogMap = new ArrayList<>();
        this.reactionLogMap = new ArrayList<>();
        this.postDetail = new PostDetail(this);
    }

    
    /* GETTERS */
    public AbstractUser getContentAuthor() {
        return contentAuthor;
    }

    public String getTextBody() {
        return textBody;
    }

    public ArrayList<UserComment> getCommentLogMap() {
        return commentLogMap;
    }

    public ArrayList<AbstractReaction> getReactionLogMap() {
        return reactionLogMap;
    }

    public String getAuthorName(){
        return getContentAuthor().getUserName();
    }

    public PostDetail getPostDetail() {
        return postDetail;
    }


    public boolean isPremium() {
        return premium;
    }

    public void setPremium() {
        this.premium = !premium;
    }

}
