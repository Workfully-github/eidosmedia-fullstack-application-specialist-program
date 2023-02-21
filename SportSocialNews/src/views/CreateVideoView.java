package views;

import controllers.SportNewsAsyncListener;
import controllers.VideoContentController;
import models.contents.Content;
import models.contents.VideoContent;
import models.users.AuthorUser;

import java.util.ArrayList;
import java.util.Scanner;

public class CreateVideoView implements SportNewsAsyncListener {

    private AuthorUser author;
    private VideoContentController videoContentController = new VideoContentController();

    public CreateVideoView(AuthorUser author) {
        this.author = author;
    }

    public void createVideoDialog(){

        Scanner in  = new Scanner(System.in);
        System.out.println("Insert title:");
        String title = in.nextLine();
        System.out.println("Insert source:");
        String src = in.nextLine();

        VideoContent content = new VideoContent(
                new AuthorUser("a","a","a"),
                "title",
                "videosrc/shjisds"
        );
        videoContentController.create(content,this);

    }


    @Override
    public void onSuccess(Content content) {

        VideoContent videoContent = (VideoContent) content;

        System.out.println("Video source : " + videoContent.getVideoSrc());

    }

    @Override
    public void onSuccess(ArrayList<Content> contents) {

    }

    @Override
    public void onError(String error) {

    }
}
