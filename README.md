# How to create an user

### 1 - Instanciate a new Controller:


    *      -> new AuthorController(AbstractUser model);
    *      -> new BasicUserController(AbstractUser model);
    *      -> new PremiumUserController(AbstractUser model);

### 2 - Controllers require a model   
    *      -> Use static #UserFactory#class: to create a model
    *      -> ex: newAuthorController(
                        UserFactory.createAbstractUser(
                            enum UserType, 
                            String name
                            ));
### 3 - Enjoy
    


## Info

I did not include bin in this project. You need to build the project in your machine in order to run this, if you find any problems runing this project contact me.
`bin`: compiled output files are generated in the `bin` folder.

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources

# Sport Social News
## Introduction
### Sport Social News is a platform where you can :
- Read news
- Comment news
- Like news
- Save favourite news
### There are 3 types of users:
- Authors that can post new contents
- Basic users that can read, comment and like free news
- Premium users that can read, comment, like free news and premium posts
### The contents can be added only by authors using different post types:
- Tweet post : has a limit of 280 characters
- Text post : has not text limit and has a cover image
- Video post : has a video and a short description (280 characters)
- Image Gallery post : has at least 2 images and a short description (280 characters)
## Requirements:
- Create a home feed section with all posts
- Create and author section with posts created by him
- Create a Post detail that contains:
- Post content
- List of comments
- List of likes
- A Premium Post can be read only by Premium Users
- A Free user can read free Posts and the first 280 characters in a Premium Content
## Nice to have features
- As an Author I have a dialog in the console to add a new Post