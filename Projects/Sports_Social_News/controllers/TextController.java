package Projects.Sports_Social_News.controllers;

import Projects.Sports_Social_News.models.GlobalPosts;
import Projects.Sports_Social_News.models.posts.TextPost;
import Projects.Sports_Social_News.models.users.AuthorUser;

public class TextController {
    public TextPost createTextPost(String publicationDate, AuthorUser author, String post, String coverImage, boolean isFree) throws NullPointerException {

        if(post.isEmpty()) return null;
        if(post.length() > 280) return null;
        if(coverImage.isEmpty()) return null;

        TextPost text = new TextPost(publicationDate, author, post, coverImage, isFree);

        author.addPost(text);
        GlobalPosts.addPostToGlobalPosts(author, text);

        return text;
    }

    public TextPost updateTextPost(TextPost text, String post) throws NullPointerException {

        if(post.isEmpty()) return null;
        if(post.length() > 280) return null;

        int index = text.getTextAuthor().getPosts().indexOf(text);
        text.setPost(post);
        
        text.getTextAuthor().updatePost(text, index);
        GlobalPosts.updatePostToGlobalPosts(text.getTextAuthor(), text);

        return text;
    }

    public TextPost updateTextImage(TextPost text, String coverImage) throws NullPointerException {

        if(coverImage.isEmpty()) return null;

        int index = text.getTextAuthor().getPosts().indexOf(text);
        text.setCoverImage(coverImage);
        
        text.getTextAuthor().updatePost(text, index);
        GlobalPosts.updatePostToGlobalPosts(text.getTextAuthor(), text);

        return text;
    }

    public TextPost updateFree(TextPost text, boolean isFree){

        int index = text.getTextAuthor().getPosts().indexOf(text);
        text.setIsFree(isFree);
        
        text.getTextAuthor().updatePost(text, index);
        GlobalPosts.updatePostToGlobalPosts(text.getTextAuthor(), text);

        return text;
    }

    public void deleteTextPost(TextPost text) {
        int index = text.getTextAuthor().getPosts().indexOf(text);
        
        text.getTextAuthor().removePost(index);
        GlobalPosts.deletePostToGlobalPosts(text.getTextAuthor(), text);
    }

    public void display(TextPost text) {
        System.out.println(text.getCoverImage());
        System.out.println(text.getPost());
        System.out.println("By: " + text.getAuthor().getDisplayName());
    }
}
