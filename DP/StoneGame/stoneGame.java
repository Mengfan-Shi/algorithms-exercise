package DP.StoneGame;

public class stoneGame {
    public static int sg(int[] piles) {
        int n = piles.length;
        Pair[][] dp = new Pair[n][n];
        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                dp[i][j] = new Pair(0, 0);
            }
        }
        // base case
        for (int i = 0; i < n; i++) {
            dp[i][i].fir = piles[i];
            dp[i][i].sec = 0;
        }
        // traverse obliquely
        for (int num = 2; num <= n; num++) {
            for (int i = 0; i <= n - num; i++) {
                int j = num + i - 1;
                int left = piles[i] + dp[i+1][j].sec;
                int right = piles[j] + dp[i][j-1].sec;
                // if the first person choose left first
                if (left > right) {
                    dp[i][j].fir = left;
                    dp[i][j].sec = dp[i+1][j].fir;
                // if the first person choose right first
                } else {
                    dp[i][j].fir = right;
                    dp[i][j].sec = dp[i][j-1].fir;
                }
            }
        }
        Pair res = dp[0][n-1];
        return res.fir - res.sec;
    }
    public static class Pair {
        int fir, sec;
        Pair(int fir, int sec) {
            this.fir = fir;
            this.sec = sec;
        }  
    }
    public static void main(String[] args) {
        int[] piles = {3, 9, 1, 2};
        int s = sg(piles);
        System.out.println(s);
    }
    
}