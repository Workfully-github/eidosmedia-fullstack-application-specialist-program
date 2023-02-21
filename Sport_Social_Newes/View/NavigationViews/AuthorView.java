package View.NavigationViews;

import java.util.Scanner;

import Controller.UsersControllers.AuthorController;
import Controller.Utils.Printer;
import Model.Users.Author;

public class AuthorView extends UserView{

    @Override
    public void show(){
        Printer.printMultiLines("Would you like to:\n", "[1] -- Read Content", "[2] -- Create Content", "[3] -- Go to Profile\n");
        Author newAuthor = new Author("visiter", "visiterUN", "visiter@ssn.net", true); 
        AuthorController authorController = new AuthorController();

        Scanner in = new Scanner(System.in);
        int userInput = in.nextInt();

        switch (userInput) {
            case 1:
                FeedView.show(newAuthor);
                break;
            case 2:
                CreateView.show(newAuthor);
                break;
            case 3:

                FeedView.showProfile(newAuthor);
                break;
        
            default:
                break;
        }
    }
}
