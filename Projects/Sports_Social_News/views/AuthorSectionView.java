package Projects.Sports_Social_News.views;

import Projects.Sports_Social_News.models.users.AuthorUser;

public class AuthorSectionView {
    
    public AuthorUser author;

    public void showAllAuthorPosts(AuthorUser author) {

        System.out.println("-----------------------------------------------");
        System.out.println("### WELCOME TO YOUR SECTION! ###");
        System.out.println("# CHECK OUT ALL YOUR POSTS: #");

        for (int i = 0; i < author.getPosts().size(); i++) {

            System.out.println(author.getPosts().get(i));
            System.out.println(author.getPosts().get(i).getDate());
            System.out.println("\n");
        }
    }
}
