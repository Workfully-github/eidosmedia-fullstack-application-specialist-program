package views;

import models.users.AuthorUser;

import java.util.Scanner;

public class WelcomeView {

    private static final int SECTION_HOME = 0;
    private static final int SECTION_AUTHORS = 1;
    private static final int SECTION_CREATE = 2;


    public void init(){
        Scanner in  = new Scanner(System.in);
        PrintViewUtils.printMultiline(
                "Welcome To Sport Social News",
                "Select an option",
                "[0] -> Home",
                "[1] -> Authors",
                "[2] -> Create content"
        );
        PrintViewUtils.print("Navigate to: ");

        int option = in.nextInt();
        openSection(option);
    }

    private void openSection(int option) {
        switch (option){
            case SECTION_HOME:
                break;
            case SECTION_AUTHORS:
                break;
            case SECTION_CREATE:
                AuthorUser authorUser = new AuthorUser("amine","Amine","Nokra");
                new CreateTweetView(authorUser).createTweetDialog();
                break;

        }
    }



}
