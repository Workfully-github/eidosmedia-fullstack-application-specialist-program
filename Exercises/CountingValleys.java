public class CountingValleys {

    public static void main (String[] args) {
        int n = 8;
        String steps = "UDDDUDUU";
        int seaLevel = 0;
        int numValleys = 0;
        boolean isValley = false;

        for (int i = 0; i < n; i++) {
            
            if (steps.charAt(i) == 'U') {
                seaLevel ++;

                if (seaLevel < 0) {
                    isValley = true;
                    System.out.println("Estou a validar o isValley true no U");
                } else if (seaLevel > 0) {
                    isValley = false;
                    System.out.println("Estou a validar o isValley false no U");
                }

                if (seaLevel == 0 && isValley == true) {
                    numValleys ++;
                    System.out.println("Estou a comparar o NumValley positivo");
                }
            }

            if (steps.charAt(i) == 'D') {
                seaLevel --;

                if (seaLevel < 0) {
                    isValley = true;
                    System.out.println("Estou a validar o isValley true no D");
                } else if (seaLevel > 0) {
                    isValley = false;
                    System.out.println("Estou a validar o isValley false no D");
                }

                if (seaLevel == 0 && isValley == true) {
                    numValleys ++;
                    System.out.println("Estou a comparar o NumValley positivo");
                }
            }
        }

        System.out.println("The number of valleys is: " + numValleys);
    } 
}