package JumpingOnTheClouds;

public class JumpingOnTheClouds {

    public static int jumpingOnTheCloudsGame(int numberOfClouds, int ... clouds ){

        int counter = 0;
        /* 
         * Renaming variables to serve as documentation
         * Explicit > Implicit
         */
        final int FINALPOSITION = clouds.length-1;

        for (int myCloudPosition = 0; myCloudPosition < clouds.length; myCloudPosition++) {

            if (myCloudPosition == FINALPOSITION){
                System.out.print("Win! ");
                break;
            }
         
            if (clouds[myCloudPosition+2] == 0){
                myCloudPosition += 1;
                counter++;
                continue;
            }
            
            if (clouds[myCloudPosition+1] == 0){
                counter++;
                continue;
            }
        }

        return counter;
    }

    public static void main(String[] args) {

        System.out.println("You jumped: " + jumpingOnTheCloudsGame(7, 0, 0, 1, 0, 0, 1, 0) + " times.");
        System.out.println("You jumped: " + jumpingOnTheCloudsGame(6, 0, 0, 0, 0, 1, 0) + " times.");

    }
}
