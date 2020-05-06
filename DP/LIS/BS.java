package DP.LIS;

/**
 * Patience poker game
 * 
 * Current poker can only be put upon the larger card
 * If no piles to put, create a new pile
 * If there are multiple piles to put, place the current poker to the least left side (ensure the pile heap is a increasing subsequence)
 */
public class BS {
    public static int lengthOfLIS(int[] nums){
        int[] top = new int[nums.length];
        // base case piles initial equals 0
        int piles = 0;
        for (int i = 0; i < nums.length; i++){
            // the poker to deal with
            int poker = nums[i];
            // binary search
            int left = 0, right = piles;
            while (left < right) {
                int mid = (left + right)/2;
                if(top[mid] > poker){
                    right = mid;
                } else if (top[mid] < poker){
                    left = mid + 1;
                } else 
                    right = mid;
            }
            // if current poker has no piles to put, create a new pile
            if(left == piles) piles++;
                top[left] = poker;
        }
        // piles = length of LIS
        return piles;
    }
    public static void main(String[] args) {
        int test[] = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(test));
    }
}