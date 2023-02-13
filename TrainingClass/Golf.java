public class Golf extends Sport {
    
    public Golf() {
        super("Golf", 1);
    }

    @Override
    public void printInfo() {
        System.out.println(name + " is a sport played by only one player");
    }
}
