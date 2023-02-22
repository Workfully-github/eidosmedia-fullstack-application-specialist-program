package SportSocialMedia.Models.Interfaces;


import SportSocialMedia.Models.Abstract.User;

public interface News {
    
    public void read();
    public void comment(User user, String comment);
    public void like(User user);

}
