

public class Game {
    public static void main (String[] args) {
        
        int n = 9;
        String NatureOfClouds = "0 0 1 0 0 1 0 0 0";
        String[] NatureOfCloudsArr = NatureOfClouds.split(" ");
        int jumps = 0;
        int currentCloudIndex;
        for(currentCloudIndex = 0; currentCloudIndex < n; currentCloudIndex++) {

            if(currentCloudIndex >= (n - 2)) break;
            jumps ++;

            if(NatureOfCloudsArr[currentCloudIndex + 2] != "1") {
                currentCloudIndex = currentCloudIndex + 1;
            }
        }
        System.out.println("You can win the game with just " + jumps + " jumps!");
    }
}