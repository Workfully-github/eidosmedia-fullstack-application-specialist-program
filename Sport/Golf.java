public class Golf extends Sport {
    public Golf() {
        super("Golf", 1);

    }
    @Override
    public void printInfo() {
        System.out.println(name + " is played by only one player");
    }
}
