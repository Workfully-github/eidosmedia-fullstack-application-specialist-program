package Projects.Sports_Social_News.views;

import Projects.Sports_Social_News.models.posts.Post;
import Projects.Sports_Social_News.models.users.AuthorUser;

public class AuthorSectionView {
    
    public AuthorUser author;

    public AuthorSectionView(AuthorUser author) {
        this.author = author;
    }

    public void showAllAuthorPosts() {
        for (Post post : author.getPosts())
            System.out.println(post);
            System.out.println(post.getDate());
    }
}
