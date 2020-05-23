package DP.KMP;

public class KMP {
    private int[][] dp;
    private String pat;

    public KMP(String pat) {
        this.pat = pat;
        int M = pat.length();
        // dp[j][c] = next
        dp = new int[M][256];
        // base case
        dp[0][pat.charAt(0)] = 1;
        // shadow state X, has same prefix with j
        int X = 0;
        for (int j = 1; j < M; j++) {
            for (int c = 0; c < 256; c++) {
                dp[j][c] = dp[X][c];
            }
            dp[j][pat.charAt(j)] = j + 1;
            // update X
            X = dp[X][pat.charAt(j)];
        }
    }

    public int search(String txt) {
        int M = pat.length();
        int N = txt.length();
        // first state = 0
        int j = 0;
        for (int i = 0; i < N; i++) {
            j = dp[j][txt.charAt(i)];
            if(j == M) return i - M + 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        KMP k = new KMP("aaab");
        int position1 = k.search("aaacaaab");
        int position2 = k.search("aaaaaaab");
        int position3 = k.search("aaaaaaaa");
        System.out.println(position1);
        System.out.println(position2);
        System.out.println(position3);
        
    }

}