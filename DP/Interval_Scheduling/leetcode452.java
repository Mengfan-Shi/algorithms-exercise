package DP.Interval_Scheduling;

import java.util.Arrays;
import java.util.Comparator;

public class leetcode452 {
    public static int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        Arrays.sort(points, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[1] - b[1];
            }
        });
        int count = 1;
        int x_end = points[0][1];
        for(int[] point: points) {
            int start = point[0];
            // equal boundary is considered overlapping here 
            if(start > x_end) {
                count ++;
                x_end = point[1];
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        int p = findMinArrowShots(points);
        System.out.println(p);    
    }
}