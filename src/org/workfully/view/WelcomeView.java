package org.workfully.view;

import java.util.Scanner;

import static org.workfully.utilities.factories.StringFactory.*;

public class WelcomeView {

    public void init(){
        Scanner in  = new Scanner(System.in);
        printMultiLn(
                "Welcome To Sport Social News",
                "Select an option",
                "[0] -> Home",
                "[1] -> Authors",
                "[2] -> Create content"
        );
        print("Navigate to: ");

        int option = in.nextInt();
        //openSection(option);
    }

/*     private void openSection(int option) {
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
    } */

}
