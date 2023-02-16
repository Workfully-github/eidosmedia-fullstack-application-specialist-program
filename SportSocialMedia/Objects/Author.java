package SportSocialMedia.Objects;

import java.util.ArrayList;

public class Author extends User {

    public void postNew(SportNew news){
        news.setPosted(true);
    }
    

}
