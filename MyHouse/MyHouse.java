package MyHouse;

public class MyHouse {

    private int numOfBedrooms;
    private String wallColor;
    private int numOfBeds;

    public MyHouse(int numOfBedrooms, String wallColor, int numOfBeds) {
        this.numOfBedrooms = numOfBedrooms;
        this.wallColor = wallColor;
        this.numOfBeds = numOfBeds;
    }

    public String setWallColor(String wallColor) {
        this.wallColor = wallColor;
        return wallColor;
    }

    public void setNumOfBedrooms(int numOfBedrooms) {
        this.numOfBedrooms = numOfBedrooms;
        updateNumOfBeds();
    }

    private void updateNumOfBeds() {
        this.numOfBeds = numOfBeds*2;
    }

    public static void main(String[] args) {
        
        MyHouse myHouse = new MyHouse(1, "Blue", 2);

        
        System.out.println("Number of bedrooms in this house: " + myHouse.numOfBedrooms);
        System.out.println("Number of beds per bedroom in this house: " + myHouse.numOfBeds);
        System.out.println("Color of the walls in this house: " + myHouse.wallColor);

        System.out.println("You have painted the house with the color: " + myHouse.setWallColor("Yellow"));
        

    }




    
}
