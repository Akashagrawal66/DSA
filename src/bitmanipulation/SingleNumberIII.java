package bitmanipulation;

import java.util.Arrays;

/*
Given an array of positive integers A, two integers appear only once, and all the
other integers appear twice.
Find the two integers that appear only once.
Note: Return the two numbers in ascending order.
*/
public class SingleNumberIII {
    public int[] solve(int[] A) {
        int pos = -1;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j : A) {
                if ((j & (1 << i)) > 0) {
                    count++;
                }
            }
            if ((count & 1) > 0) {
                pos = i;
                break;
            }
        }

        int xorA = 0;
        int xorB = 0;
        for (int i : A) {
            if ((i & (1 << pos)) > 0) {
                xorA ^= i;
            } else {
                xorB ^= i;
            }
        }
        int[] result = new int[2];
        if (xorA > xorB) {
            result[0] = xorB;
            result[1] = xorA;
        } else {
            result[0] = xorA;
            result[1] = xorB;
        }
        return result;
    }

    public static void main(String[] args) {
        SingleNumberIII obj = new SingleNumberIII();
        int[] A = {1, 2};
        System.out.println(Arrays.toString(obj.solve(A)));
    }
}
