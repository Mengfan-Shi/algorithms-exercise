package DP.Interval_Scheduling;

import java.util.Arrays;
import java.util.Comparator;

public class intervalSchedule {
    public static int schedule(int[][] intvs){
        if(intvs.length == 0) return 0;
        // sort every interval's end by ascending order
        Arrays.sort(intvs, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[1] - b[1];
            }
        });
        // Arrays.sort(intvs[1]);

        // at least one interval does not overlapping
        int count = 1;
        int x_end = intvs[0][1];
        for(int[] interval: intvs) {
            int start = interval[0];
            // find interval that doest not overlap with the current interval
            if(start >= x_end) {
                count ++;
                x_end = interval[1];
            }
        }
    return count;
    }
    public static void main(String[] args) {
        int[][] intvs = {{1,3}, {2,4}, {3,6}};
        int s = schedule(intvs);
        System.out.println(s);
    }
}