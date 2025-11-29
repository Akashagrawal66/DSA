package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
You are given 3 sorted arrays A, B and C.
Find i, j, k such that : max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])).
Input 1:
 A = [1, 4, 10]
 B = [2, 15, 20]
 C = [10, 12]
Input 2:
 A = [3, 5, 6]
 B = [2]
 C = [3, 4]
Output 1:
 5
Output 2:
 1
*/
public class Array3Pointers {

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        int i = 0, j = 0, k = 0;
        int minDiff = Integer.MAX_VALUE;
        while (i < A.size() && j < B.size() && k < C.size()) {
            int num1 = A.get(i);
            int num2 = B.get(j);
            int num3 = C.get(k);
            minDiff = Math.min(minDiff, Math.max(Math.max(Math.abs(num1 - num2), Math.abs(num3 - num2)), Math.abs(num1 - num3)));
            if (i < A.size() - 1 && num1 < num2 && num1 < num3) {
                i++;
            } else if (j < B.size() - 1 && num2 < num3) {
                j++;
            } else if (k < C.size() - 1) {
                k++;
            } else {
                break;
            }
        }
//        System.out.println(i+" "+j+" "+k);
        return minDiff;
    }

    public static void main(String[] args) {
        Array3Pointers obj = new Array3Pointers();
        List<Integer> list1 = Arrays.asList(3,5,6);
        List<Integer> list2 = Arrays.asList(2);
        List<Integer> list3 = Arrays.asList(3,4);
        System.out.println(obj.minimize(list1, list2, list3));
    }
}
