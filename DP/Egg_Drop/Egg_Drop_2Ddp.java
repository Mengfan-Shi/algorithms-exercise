package DP.Egg_Drop;
/**
 * Improvement2: change state transfer function
 * dp[k][m] = n : exist k eggs, max drop times m, can test n floors in worst case
 * 
 * dp[k][m-1]: upstairs number(egg not broken)
 * dp[k-1][m-1]: downstairs number(egg broken)
 * 
 * O(time) = O(KN)
 */

public class Egg_Drop_2Ddp {
    public static int eggDrop(int K, int N) {
        int[][] dp = new int[K+1][N+1];
        // base case
        // dp[0][...] = 0
        // dp[...][0] = 0
        int m = 0;
        while(dp[K][m] < N){
            m++;
            for (int k = 1; k <= K; k++){
                dp[k][m] = dp[k][m-1] + dp[k-1][m-1] + 1; 
                // always add the current floor
            }
        }
        return m;
    }
public static void main(String[] args) {
    int K =2, N = 100;
    int m = eggDrop(K, N);
    System.out.println(m);
}
}