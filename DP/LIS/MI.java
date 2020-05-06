package DP.LIS;

import java.util.Arrays;

public class MI {
    public static int lengthOfLIS(int[]nums) {
        int[] dp = new int[nums.length];
        // base case dp = 1
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int res = 0;
        for(int a = 0; a < dp.length; a++) {
            res = Math.max(res, dp[a]);
        }
        return res;
    }
    public static void main(String[] args) {   
        int[] test = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(test));
    }
}
    
