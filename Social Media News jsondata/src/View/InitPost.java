package View;

import java.util.ArrayList;
import java.util.Scanner;

import Models.Content.ImagePost;
import Models.Content.TextPost;
import Models.Content.TweetPost;
import Models.Content.VideoPost;
import Models.User.Author;

public class InitPost {
    private static final Scanner sc= new Scanner(System.in); 

    public static TweetPost createTweetPost(Author author){
        System.out.print("\nCreating tweet Post ....\n");

        System.out.print("Enter post title- : ");  
        String postName= sc.next();  
        System.out.print("Enter tweet body text- : ");  
        String body= sc.next();  
        System.out.print("Is the post premium? (true/false): ");
        boolean isPremium = sc.nextBoolean();
        sc.nextLine();
        System.out.println();
        return new TweetPost(postName, body, author, isPremium);
    }

    public static ImagePost createImagePost(Author author){
        System.out.print("\nCreating image Post ....");

        System.out.print("Enter post title- : ");  
        String postName= sc.next(); 
        System.out.print("Enter first image url- : ");  
        String url1= sc.next(); 
        System.out.print("Enter seconde image url- : ");  
        String url2= sc.next(); 
        ArrayList<String> images = new ArrayList<>();
        images.add(url1);
        images.add(url2);
        System.out.print("Enter post description- : ");  
        String description= sc.next(); 
        System.out.print("Is the post premium? (true/false): ");
        boolean isPremium = sc.nextBoolean();
        System.out.println();
        sc.nextLine();
        return new ImagePost(images, description,postName, author, isPremium);
    }

    public static TextPost createTextPost(Author author){
        System.out.print("\nCreating text Post ....");

        System.out.print("Enter post title- : ");  
        String name= sc.next();  
        System.out.print("Enter cover image url- : ");  
        String url= sc.next();  
        System.out.print("Enter post body- : ");  
        String body= sc.next(); 
        System.out.print("Is the post premium? (true/false): ");
        boolean isPremium = sc.nextBoolean();
        System.out.println();
        sc.nextLine();
        return new TextPost(name, url, body, author, isPremium);
    }

    public static VideoPost createVideoPost(Author author){
        System.out.print("\nCreating tweet Post ....");

        System.out.print("Enter post title- : ");  
        String postName= sc.next();  
        System.out.print("Enter cover video url- : ");  
        String url= sc.next();  
        System.out.print("Enter post body- : ");  
        String body= sc.next(); 
        System.out.print("Is the post premium? (true/false): ");
        boolean isPremium = sc.nextBoolean();
        System.out.println();
        sc.nextLine();
        return new VideoPost(postName, url, body, author, isPremium);
    }
}
