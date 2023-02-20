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

        presentIfComment();
        presentIfTextPost();
        presentIfTweet();
    }

    private void presentIfComment() {
        if (content instanceof UserComment) {

            System.out.println("### COMMENT VIEW ###");
            for (UserComment comment : content.getCommentLogMap()) {
                System.out.println("Created by: " + comment.getAuthorName());
                System.out.println(comment.getTextBody());
                // System.out.println(comment.getReactionLogMap().size() + " likes");

            }
        }
    }

    private void presentIfTweet() {
        if (content instanceof Tweet) {
            System.out.println("Tweet: " + content.getTextBody());
            System.out.print("\n");
        }
    }

    private void presentIfTextPost() {
        if (content instanceof TextPost) {
            System.out.println("Header: " + ((TextPost) content).getCoverImgURL());
            System.out.println("Text Post: " + content.getTextBody());
            System.out.print("\n");
        }
    }

}
