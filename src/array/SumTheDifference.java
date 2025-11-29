package array;

import java.util.Arrays;

public class SumTheDifference {
    public int solve(int[] A) {
        int mod = (int) (1e9 + 7);
        Arrays.sort(A);
        long num = 1;
        long max = 0;
        long min = 0;
        for (int j : A) {
            max = (max + (num * j));
            num = (num * 2) % mod;
        }
        num = 1;
        for (int i = A.length - 1; i >= 0; i--) {
            min = (min + (num * A[i]));
            num = ((num * 2) % mod);
        }
        return (int) ((max - min) % mod);
    }

    public static void main(String[] args) {
        SumTheDifference obj = new SumTheDifference();
        int[] A = {1, 2};
        System.out.println(obj.solve(A));
    }
}
