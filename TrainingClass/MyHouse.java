public class MyHouse {
    
    int numbBedrooms, numbBeds;
    String wallColor;

    public MyHouse(int numbBedrooms, String wallColor, int numbBeds) {
        this.numbBedrooms = numbBedrooms;
        this.wallColor = wallColor;
        this.numbBeds = numbBeds;
    }
    
    public void changeWallColor(String wallColor) {
        this.wallColor = wallColor;
    }
    
    public void changeNumbBedrooms(int numbBedrooms) {
        this.numbBedrooms = numbBedrooms;
        changeNumbBeds();
    }
    
    private void changeNumbBeds() {
        numbBeds = 2 * numbBedrooms;
    }

    public static void main(String[] args) {
        MyHouse portugal = new MyHouse(3, "grey", 2);
        MyHouse italy = new MyHouse(2, "white", 1);
    
        portugal.changeWallColor("blue");
        portugal.changeNumbBedrooms(5);
        italy.changeNumbBedrooms(3);
        System.out.println("Number of beds in Portugal: " + portugal.numbBeds);
        System.out.println("Number of beds in Italy: " + italy.numbBeds);
    }
}
