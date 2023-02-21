package Controller.UsersControllers;

import Controller.ContentControllers.CreateImagePostController;
import Controller.ContentControllers.CreateTextPostController;
import Controller.ContentControllers.CreateTweetsController;
import Controller.ContentControllers.CreateVideoPostController;

public class AuthorController {
    CreateTweetsController createTweetsController = new CreateTweetsController();
    CreateTextPostController createTextPostController = new CreateTextPostController();
    CreateImagePostController createImagePostController = new CreateImagePostController();
    CreateVideoPostController createVideoPostController = new CreateVideoPostController();
    
}
