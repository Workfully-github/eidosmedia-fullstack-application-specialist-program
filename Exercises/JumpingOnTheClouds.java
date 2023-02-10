public class JumpingOnTheClouds {
    public static void main (String[] args) {
        
        int n = 30;
        String initialSequence = "0 0 1 0 0 1 0 0 1 0 1 0 0 1 0 0 0 1 0 0 1 0 0 1 0 1 0 0 1 0";
        String[] sequenceArray = initialSequence.split(" ");
        String sequence = String.join("", sequenceArray);
        int jumps = 0;
        
        for(int i = 0; i < n; i++) {

            if(i >= (n - 2)) break;
            jumps ++;

            if(sequence.charAt(i + 2) != '1') {
                i = i + 1;
            }
        }
        System.out.println("You won the game with " + jumps + " jumps!");
    }
}
