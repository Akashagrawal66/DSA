package array;

import java.util.Arrays;

public class MInDiffPuzzle {

    public int solve(int[] A, int B) {
        Arrays.sort(A);
        int result = Integer.MAX_VALUE;
        for (int i=0;i<=A.length-B;i++){
            result = Math.min(result, A[B-1+i] - A[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {10, 12, 10, 7, 5, 22};
        int B = 4;
        MInDiffPuzzle obj = new MInDiffPuzzle();
        System.out.println(obj.solve(A,B));
    }
}
