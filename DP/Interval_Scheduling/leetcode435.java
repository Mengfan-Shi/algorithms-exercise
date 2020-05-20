package DP.Interval_Scheduling;

import java.util.Arrays;
import java.util.Comparator;

public class leetcode435 {
    public static int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if(n == 0) return 0;
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[1] - b[1];
            }
        });
        int count = 1;
        int x_end = intervals[0][1];
        for(int[] interval: intervals){
            int start = interval[0];
            if(start >= x_end){
                count ++;
                x_end = interval[1];
            }
        }
        return n - count;
    }
    public static void main(String[] args) {
        int[][] intvs = {{1,3}, {2,4}, {3,6}};
        int s = eraseOverlapIntervals(intvs);
        System.out.println(s);
    }
    
}