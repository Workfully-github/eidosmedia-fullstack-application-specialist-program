public class MyHouse {
    int numOfBedrooms;
    String wallColor;
    int numOfBeds;

    public MyHouse(int numBedrooms, String color, int beds) {
        numOfBedrooms = numBedrooms;
        wallColor = color;
        numOfBeds = beds;
    }
    
    public void changeColor(String newColor){
        wallColor = newColor;
    }
    
    private void changeNumOfBeds(int newNumOfBeds) {
        numOfBeds = newNumOfBeds;
    }
    public void changeNumOfBedrooms(int newNumOfBedrooms) {
        numOfBedrooms = newNumOfBedrooms;
        changeNumOfBeds(newNumOfBedrooms * 2);
    }
    public static void main(String[] args) {
        MyHouse home = new MyHouse(2, "white", 2);
        home.changeNumOfBedrooms(3);
        System.out.println("num of bedrooms is: " + home.numOfBedrooms);
        System.out.println("num of beds is: " + home.numOfBeds);
        
    }

}