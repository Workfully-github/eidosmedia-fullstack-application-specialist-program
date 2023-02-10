package JumpingOnCloud;

public class JumpingOnCloud {

    public static int jumpingOnCloud_n(int[] clouds){
        int N = clouds.length;
        int emmaIsPosition = 0;
        int jumps = 0;
        if(N<=1){
            return jumps;
        }

        int i=1;
        while( i<N){
            if(i <= N - 2){
                if(clouds[i + 1]==0){
                    emmaIsPosition = i + 1;
                    jumps += 1;
                    i = emmaIsPosition + 1;
                }
                else if (clouds[i + 1]!=0 && clouds[i]==0){
                    emmaIsPosition = i;
                    jumps +=1 ;
                    i = emmaIsPosition + 1;
                }
                else{
                    System.out.println("the two following clouds is not ordinary clouds");
                    return 0;
                }
            }
            else {
                if (clouds[i]==0){
                    emmaIsPosition = i;
                    jumps += 1;
                    i++;
                }
                else {
                    System.out.println("the last cloud is not a ordinary cloud!!");
                    return 0;
                }
            }
        }
        return jumps;
    }
    
    public static void main(String[] args) {
        //o for ordinary-cloud and t for thunderclouds
        int[] clouds = {0,0,0,0,1,0};
        int jumps = JumpingOnCloud.jumpingOnCloud_n(clouds);

        System.out.println("the minimum number jumps needed to win the game is : " + jumps);
    }
}
