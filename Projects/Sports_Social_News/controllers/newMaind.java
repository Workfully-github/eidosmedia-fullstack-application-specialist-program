package Projects.Sports_Social_News.controllers;

public public void init() {

    Scanner userInput = new Scanner(System.in);
    System.out.println("Welcome! Let's relax and read some news");
    System.out.println("\n");
    System.out.println("Please select where you want to go");
    System.out.println("[H] --> Home");
    System.out.println("[A] --> Authors");
    System.out.println("[C] --> Create Post");
    System.out.print("Let's go to: ");
    System.out.print("--------------------------------------------");

    String userChoice = userInput.nextLine();

    openChoice(userChoice);
}

public void openChoice(String openChoice) {

    switch (openChoice) {
        case HOME_PAGE:
        // selectUser() calls the create dialog view based on the input of type of user and type of post
            selectUser();
            break;
        case AUTHORS_PAGE:
            // see what user it is?
            // if it's author , use selectPost() method, else, print message saying it's not possible
            break;
        case CREATE_PAGE:
            // see what user it is?
            // if it's author , use selectPost() method, else, print message saying it's not possible
            break;
    }
}

// select type of user to loggin with
public void selectUser() {
    
    Scanner userInput = new Scanner(System.in);
    System.out.println("Let's create some news!");
    System.out.println("\n");
    System.out.println("Which kind of user do you want to log in with?");
    System.out.println("[1] --> Basic");
    System.out.println("[2] --> Author");
    System.out.println("[3] --> Premium");
    System.out.print("Let's log in as: ");
    System.out.print("--------------------------------------------");

    int userChoice = userInput.nextInt();

    switch (userChoice) {
        case BASIC:
            NormalUser basicUser = new NormalUser("medhi", "Medhi", "Taremi", false);
            /* selectPost(); */
            break;
        case AUTHOR:
            AuthorUser authorUser = new AuthorUser("mateus", "Mateus", "Uribe");
            // option to go to hoem
            selectPost(authorUser);
            break;
        case PREMIUM:
            NormalUser premiumUser = new NormalUser("sergio", "Sergio", "Conceicao", true);
            /* selectPost(); */
            break;
    }
}

// select what kind of post to create
public void selectPost(AuthorUser author) {

    Scanner userInput = new Scanner(System.in);
    System.out.println("\n");
    System.out.println("What type of post are you creating?");
    System.out.println("[1] --> Tweet");
    System.out.println("[2] --> Text");
    System.out.println("[3] --> Image");
    System.out.println("[4] --> Video");
    System.out.print("Let's create some content: ");
    System.out.print("--------------------------------------------");

    int userChoice = userInput.nextInt();

    switch (userChoice) {
        case TWEET:
            new CreateTweetView(author).createTweetDialog();
            break;
        case TEXT:
            new CreateTextView(author).createTextDialog();
            break;
        case IMAGE:
            new CreateImageView(author).createImageDialog();
            break;
        case VIDEO:
            new CreateVideoView(author).createVideoDialog();
            break;
    }
} {
    
}
