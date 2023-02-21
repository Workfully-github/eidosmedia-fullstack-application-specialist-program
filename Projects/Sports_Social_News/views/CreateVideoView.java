package Projects.Sports_Social_News.views;

import java.util.Scanner;

import Projects.Sports_Social_News.controllers.VideoController;
import Projects.Sports_Social_News.models.posts.VideoPost;
import Projects.Sports_Social_News.models.users.AuthorUser;

public class CreateVideoView {
    
    public AuthorUser author;

    public CreateVideoView(AuthorUser author) {
        this.author = author;
    }

    public void createVideoDialog() {
        Scanner authorInput = new Scanner(System.in);
        System.out.println("Insert the date o publication:");
        String publicationDate = authorInput.nextLine();
        System.out.println("Insert the description of your video:");
        String description = authorInput.nextLine();
        System.out.println("Insert your video link:");
        String videoUrl = authorInput.nextLine();
        
        VideoController videoController = new VideoController();

        try {
            VideoPost video = videoController.createVideoPost(publicationDate, author, description, videoUrl);
            videoController.display(video);

        } catch (Exception e) {
            System.out.println("Your video is not valid. Please try again.");
            System.out.println("Your description might be to big/inexistent or your video link doesn't exist.");
        }
    }
}
