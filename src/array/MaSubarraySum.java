package array;

import java.util.Arrays;

public class MaSubarraySum {
    public int[] max(int[] A) {
        int sum = 0;
        int max = 0;
        int start = 1, end = 0;
        int ansStart = -1, ansEnd = -1;
        for(int i=0;i<A.length;i++) {
            sum += (A[i] ==1? -1:1);
            end++;
            if(sum < 0) {
                sum = 0;
                start = end+1;
            }
            if(max < sum ) {
                max = sum;
                ansStart = start;
                ansEnd = end;
            }
        }
        if(ansStart == -1) {
            return new int[0];
        }
        return new int[]{ansStart, ansEnd};
    }

    public static void main(String[] args) {
        MaSubarraySum obj = new MaSubarraySum();
        int[] A = {1,1,0};
        System.out.println(Arrays.toString(obj.max(A)));
    }
}
