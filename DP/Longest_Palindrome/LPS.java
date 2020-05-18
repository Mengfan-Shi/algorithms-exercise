package DP.Longest_Palindrome;

public class LPS {
    public static int LongestPalindromeSubseq(String s) {
        // tansfer string to array
        char[] data = s.toCharArray();
        int n = data.length;
      int [][] dp = new int [n+1][n+1];
        // base case
        for (int i = 0; i < n; i++){
            dp[i][i] = 1;
        }
        // reversal traverse
        for (int i = n-1; i >= 0; i--) {
            for(int j = i+1; j < n; j++){
                if (data[i] ==data[j]) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                }
                else 
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
            }
        }
        return dp[0][n-1];
    }
    public static void main(String[] args) {
        String s1 = "abxabyb";
        String s2 = "cbxabyc";
        int a = LongestPalindromeSubseq(s1);
        int b = LongestPalindromeSubseq(s2);
        System.out.println(a);
        System.out.println(b);
    }
}