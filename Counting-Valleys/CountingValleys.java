
class CountingValleys {
    public static void main(String[] args) {
        // DDDUUDUUUDDUU 13   ---->     Expected Output: not at sea level \n 2
        // UDDDUDUU 8         ---->     Expected Output: 1
        // DDUUDDUDUUUD 12    ---->     Expected Output: 2
        // DUDDDUUDUU 10      ---->     Expected Output: 2
        
        String s = "UDDDUDUU";
        char[] arrayOfSteps = s.toUpperCase().toCharArray();
        int level = 0;
        int numOfVall = 0;

        if ( s.length() < 2 || s.length() > 1000000) {
            System.out.print("The number of steps (n) must be greater or equal to 2 and less or equal to 10^6!");
            return;
        }
       
        for(int i = 0; i < s.length();  i++){
            if(arrayOfSteps[i] == 'D'){
                level--;
            }else if(arrayOfSteps[i] == 'U'){
                level++;
            }
            if(level == 0 && arrayOfSteps[i] == 'U'){
                numOfVall++;
            }
        }

        if(level !=0) {
            System.out.println("You're not at sea level yet, keep going!");
        }
        System.out.print(numOfVall);
    }
}