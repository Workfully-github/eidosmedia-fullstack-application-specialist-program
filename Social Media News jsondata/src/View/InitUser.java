package View;

import java.util.Scanner;

import Models.Abstract.User;
import Models.User.BasicUser;
import Models.User.PremuimUser;
import Models.Content.Content;
import Models.User.Author;

public class InitUser {

    public static int id = 0;
    private static final Scanner sc= new Scanner(System.in); 

    public static Author createAuthor(){

        System.out.print("\nCreating Author ....\n");

        System.out.print("Enter author name- : ");  
        String name= sc.next();  
        System.out.print("Is the author premium? (true/false): ");
        boolean isPremium = sc.nextBoolean();
        sc.nextLine();
        Author user =  new Author(name, id+"", isPremium);
        id +=1;
        return user;
    }

    public static User createUser(boolean isPremium) {
        System.out.println("\nCreating new user...");
        if(isPremium){
            System.out.println("it will be premium!");
        }

        System.out.print("Enter user name: ");
        String name = sc.nextLine();

        if (isPremium) {
            return new PremuimUser(name, (id++)+"");
        } else {
            return new BasicUser(name, (id++)+"");
        }
    }

    public static BasicUser createBasicUser(){

        Scanner sc= new Scanner(System.in); 
        System.out.print("\nCreate Basic User ");

        System.out.print("Enter user name- : ");  
        String name= sc.next();  
        BasicUser user =  new BasicUser(name,id+"");
        id +=1;
        return user;
    }

    public static PremuimUser createPremuimUser(){

        Scanner sc= new Scanner(System.in); 
        System.out.print("\nCreate Basic User ");

        System.out.print("Enter user name- : ");  
        String name= sc.next();  
        PremuimUser user =  new PremuimUser(name,id+"");
        id +=1;
        return user;
    }
    
}
