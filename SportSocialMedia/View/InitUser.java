package SportSocialMedia.View;

import java.util.Scanner;

import SportSocialMedia.Models.Abstract.User;
import SportSocialMedia.Models.Content.Content;
import SportSocialMedia.Models.User.Author;
import SportSocialMedia.Models.User.BasicUser;
import SportSocialMedia.Models.User.PremuimUser;

public class InitUser {

    public static int id = 0;

    public static Author createAuthor(){

        Scanner sc= new Scanner(System.in); 
        System.out.print("\nCreate Author User ");

        System.out.print("Enter user name- : ");  
        String name= sc.next();  
        Author user =  new Author(name,id+"");
        id +=1;
        return user;
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
