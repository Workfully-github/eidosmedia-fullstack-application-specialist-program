public class MyProfile {

    public String myName = "Ricardo Mendes";

    public int age = 31;

    public char gender = 'M';

    public boolean likesCoffe = true;

    public static void main(String[] args) {
        
        MyProfile myProfile = new MyProfile();

        System.out.println("My name is: " + myProfile.myName);
        System.out.println("My age is: " + myProfile.age);
        System.out.println("My gender is: " + myProfile.gender);
        System.out.println("My likesCoffe is: " + myProfile.likesCoffe);
    }
    
}
