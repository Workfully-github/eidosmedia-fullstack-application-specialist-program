package org.workfully.view.section;

import org.workfully.models.content.AbstractContent;
import org.workfully.models.content.TextPost;
import org.workfully.models.content.Tweet;
import org.workfully.models.content.UserComment;

public class PostDetail extends AbstractSection {

    /* PROPERTIES */
    private AbstractContent content;

    /* CONSTRUCTOR */
    public PostDetail(AbstractContent content) {
        this.content = content;
    }

    /* METHODS */
    public void showPostDetail() {

        presentIfTextPost();
        presentIfComment();
        presentIfTweet();
        presentIfComment();
    }

    public void showPostDetailFree() {

        presentIfTweet();

        if (content.isPremium() && content.getTextBody().length() > 280) {
            presentIfPremiumTextPost();
            presentIfComment();
            return;
        }

        presentIfTextPost();
        presentIfComment();
    }

    private void presentIfComment() {
        if(!content.getCommentLogMap().isEmpty()){
            System.out.println("### COMMENT VIEW ###");
        }
            for (UserComment comment : content.getCommentLogMap()) {
                System.out.println("Created by: " + comment.getAuthorName());
                System.out.println(comment.getTextBody());
                System.out.println(comment.getReactionLogMap().size() + " likes \n");
            }
        
    }

    private void presentIfTweet() {
        if (content instanceof Tweet) {
            System.out.println("Tweet: " + content.getTextBody());
            System.out.println(content.getReactionLogMap().size() + " likes");
            System.out.print("\n");
        }
    }

    private void presentIfTextPost() {
        if (content instanceof TextPost) {
            System.out.println("Header: " + ((TextPost) content).getCoverImgURL());
            System.out.println("Text Post: " + content.getTextBody());
            System.out.println(content.getReactionLogMap().size() + " likes");
            System.out.print("\n");
        }
    }

    private void presentIfPremiumTextPost() {
        if (content instanceof TextPost) {
            System.out.println("You are viewing a Premium Post as a Basic User");
            System.out.println("Header: " + ((TextPost) content).getCoverImgURL());
            System.out.println("Text Post: " + content.getTextBody().substring(0, 280));
            System.out.println(content.getReactionLogMap().size() + " likes");
            System.out.print("\n");
        }
    }

    /* GETTERS */
    public AbstractContent getContent() {
        return content;
    }
}
