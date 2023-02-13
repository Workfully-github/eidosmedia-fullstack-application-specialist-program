package Excercise13_02;

public class Golf  extends Sport{

    public Golf() {
        super("Golf", 1);
    }

    @Override
    public String printInfo() {
        return name + " is a sport played by only one player" ;
    }
    
}
