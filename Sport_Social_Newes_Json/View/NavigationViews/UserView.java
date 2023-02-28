package View.NavigationViews;

import Model.Users.User;

public class UserView {
User premiumUser = new User("Premium User", "PU", "test@ssn.com", true);
User BasicUser = new User("Basic User", "BU", "testBu@ssn.com", false);
public void showPremium() {
    FeedView.show(premiumUser);
}
    public void show() {
        FeedView.show(BasicUser);
    }

    public void show(User user) {
        FeedView.show(BasicUser);
    }

}
