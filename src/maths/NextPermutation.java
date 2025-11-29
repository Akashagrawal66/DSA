package maths;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/*
* Implement the next permutation, which rearranges numbers into the numerically next greater
* permutation of numbers for a given array A of size N.
If such arrangement is not possible, it must be rearranged as the lowest possible order, i.e., sorted in ascending order.
NOTE:
The replacement must be in place, do not allocate extra memory.
DO NOT USE LIBRARY FUNCTION FOR the NEXT PERMUTATION. Use of Library functions will disqualify your submission
* retroactively and will give you penalty points.*/
public class NextPermutation {

    public int[] nextPermutation(int[] A) {
        int i = 0;
        int n = A.length;
        for (i = n - 2; i >= 0; i--) {
            if (A[i] < A[i + 1]) {
                break;
            }
        }
        if (i == -1) {
            Arrays.sort(A);
            return A;
        }
        int j;
        for (j = n - 1; j > i; j--) {
            if (A[j] > A[i]) {
                break;
            }
        }
        swap(A, i, j);
        i++;
        for (int k = i, p = n - 1; k < p; k++, p--) {
            swap(A, k, p);
        }
        return A;
    }

    private void swap(int[] A, int index1, int index2) {
        int temp = A[index1];
        A[index1] = A[index2];
        A[index2] = temp;
    }

    public static void main(String[] args) {
        NextPermutation obj = new NextPermutation();
        int[] A = {1, 3, 4, 2, 6, 8, 7, 5};
        System.out.println(Arrays.toString(obj.nextPermutation(A)));

    }
}
