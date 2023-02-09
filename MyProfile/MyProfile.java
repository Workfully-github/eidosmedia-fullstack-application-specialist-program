package MyProfile;
public class MyProfile {
    private String name;
    private Integer age;
    private String gender;
    private Boolean wantCofee;

    public MyProfile(String name, Integer age, String gender, Boolean wantCofee) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.wantCofee = wantCofee;
    }

    @Override
    public String toString() {
        return "MyProfile [name=" + name + ",\n age=" + age + ",\n gender=" + gender + ",\n wantCofee=" + wantCofee + "]";
    }
    
    
}
