package org.workfully.view.section;

import org.workfully.models.content.AbstractContent;
import org.workfully.models.content.ImageGalleryPost;
import org.workfully.models.content.TextPost;
import org.workfully.models.content.Tweet;
import org.workfully.models.content.UserComment;
import org.workfully.models.content.VideoPost;

import static org.workfully.utilities.factories.StringFactory.*;

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
        presentIfTweet();
        presentIfImgGallery();
        presentIfVideoPost();
    }

    public void showPostDetailFree() {
        presentIfTweet();
        if (content.isPremium() && content.getTextBody().length() > 280) {
            presentIfPremiumTextPost();
            presentIfComment();
            return;
        }
        presentIfTextPost();
        presentIfImgGallery();
        presentIfVideoPost();
    }

    private void presentIfComment() {
        if (!content.getCommentLogMap().isEmpty())
            printLn("### COMMENT VIEW ###");

        for (UserComment comment : content.getCommentLogMap())
            printMultiLn(
                    "Created by: " + comment.getAuthorName(),
                    comment.getTextBody(),
                    comment.getReactionLogMap().size() + " likes \n");
    }

    private void presentIfTweet() {
        if (content instanceof Tweet)
            printMultiLn(
                    "Tweet: " + content.getTextBody(),
                    content.getReactionLogMap().size() + " likes \n");

        presentIfComment();
    }

    private void presentIfTextPost() {
        if (content instanceof TextPost) {
            printMultiLn(
                    "Type: Text Article",
                    "Header: " + ((TextPost) content).getCoverImgURL(),
                    "Text Post: " + content.getTextBody(),
                    content.getReactionLogMap().size() + " likes \n");

            presentIfComment();
        }
    }

    private void presentIfVideoPost() {
        if (content instanceof VideoPost) {
            printMultiLn(
                    "Type: Video Post",
                    "Header: " + ((VideoPost) content).getURL(),
                    "Text Post: " + content.getTextBody(),
                    content.getReactionLogMap().size() + " likes \n");

            presentIfComment();
        }
    }

    private void presentIfImgGallery() {
        if (content instanceof ImageGalleryPost) {
            printMultiLn(
                    "Type: Image Gallery",
                    "Header: " + ((ImageGalleryPost) content).getURL(),
                    "Text Post: " + content.getTextBody(),
                    content.getReactionLogMap().size() + " likes \n");

            presentIfComment();
        }
    }

    private void presentIfPremiumTextPost() {
        if (content instanceof TextPost) {
            printMultiLn(
                    "Type: Text Post",
                    "You are viewing a Premium Post as a Basic User",
                    "Header: " + ((TextPost) content).getCoverImgURL(),
                    "Text Post: " + content.getTextBody().substring(0, 280),
                    content.getReactionLogMap().size() + " likes \n");

            presentIfComment();
        }
    }

    /* GETTERS */
    public AbstractContent getContent() {
        return content;
    }
}
