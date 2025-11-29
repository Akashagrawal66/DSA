package maths;

import java.util.Arrays;

/**
 * Given three integers A, B, and C, where A represents n, B represents r, and C represents m,
 * find and return the value of nCr % m where nCr % m = (n!/((n-r)!*r!))% m.
 * x! Means factorial of x i.e x! = 1 * 2 * 3... * x.
 */
public class ComputenCrmodM {
    public int solve(int A, int B, int C) {
        if (B > A - B)
            B = A - B;
        int[] arr = new int[B + 1];
        arr[0] = 1;
        for (int i = 1; i <= A; i++) {
            int prev = arr[0];
            for (int j = 1;j<=(Math.min(i,B));j++) {
                int temp = arr[j];
                arr[j] = (int)(((long)arr[j] + prev)%C);
                prev = temp;
            }
            System.out.println(Arrays.toString(arr));
        }
        System.out.println(Arrays.toString(arr));
        return arr[B];
    }

    public static void main(String[] args) {
        int A = 5;
        int B = 2;
        int C = 13;
        ComputenCrmodM obj = new ComputenCrmodM();
        System.out.println(obj.solve(A, B, C));
    }
}
