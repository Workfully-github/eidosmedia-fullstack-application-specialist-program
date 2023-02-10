public class CountingValleys {

    public static int numberOfValleys(String stepsString){

        int level = 0;

        int bellowSeaLevelConsecutiveStepsCounter = 0;

        int valleyCounter = 0;

        boolean isValley = false;

        boolean isOutsideValley = true;

        for (int i = 0; i < stepsString.length(); i++) {

            if(stepsString.charAt(i) == 'U'){
                level++;
                bellowSeaLevelConsecutiveStepsCounter--;
            }
            
            if(stepsString.charAt(i) == 'D'){
                level--;
                bellowSeaLevelConsecutiveStepsCounter++;
            }

            if(bellowSeaLevelConsecutiveStepsCounter == 1){
                isValley = true;
            }

            if(bellowSeaLevelConsecutiveStepsCounter != 1){
                isValley = false;
            }

            if(isValley && isOutsideValley){
                valleyCounter++;
                isOutsideValley = false;
            }

            if(level == 0){
                isOutsideValley = true;
            }

            System.out.println(level);

        }

        return valleyCounter;
    }

    public static void main(String[] args) {

        /* String samplePattern = "UDDDUDUU";
        String samplePattern2 = "UUDUDUDDUDUDUDDDDDDUDUU";
        String samplePattern3 = "UDDDUDDUUUUDUDUDUUUDUDDUU";
        String samplePattern4 = "UDDDUDUUDUDUDUDDDUUUUDDUU";
        String twoValleysOneMountain = "UDDDUDUUUUUDDDDDDDDUUUDUDUDDUUUU";
        String twoMountainsOneValley = "UUDDDDUDUUUUDDUUDD"; */

        
        //System.out.println("\n" + numberOfValleys(samplePattern));
        //System.out.println("\n" + numberOfValleys(samplePattern2));
        //System.out.println("\n" + numberOfValleys(samplePattern3));
        //System.out.println("\n" + numberOfValleys(samplePattern4));
        //System.out.println("\n" + numberOfValleys(twoValleysOneMountain));
        System.out.println("\n" + numberOfValleys("twoMountainsOneValley"));
    }
    
}
