package twopointers;

import sorting.UniqueElements;

import java.util.ArrayList;
import java.util.stream.IntStream;

/*
Given a binary array A, find the maximum sequence of continuous 1's that can be formed by replacing at-most B zeroes.
For this problem, return the indices of maximum continuous series of 1s in order.
If there are multiple possible solutions, return the sequence which has the minimum start index.
*/
public class MaxContinuousSeriesOf1s {

    public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {
        int max = Integer.MIN_VALUE;
        int count = 0;
        int start1 = -1;
        int start2 = -1;
        for (int i = 0, j = 0; i < A.size(); i++) {
            int num = A.get(i);
            if (num == 0) {
                count++;
            }

            if (count > B) {
                while (count > B) {
                    if (A.get(j) == 0) {
                        count--;
                    }
                    j++;
                }
            }
            if ((i - j + 1) > max) {
                start1 = j;
                start2 = i;
                max = (i - j + 1);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        IntStream.range(start1, start2 + 1).boxed().forEach(result::add);
        return result;
    }

    public static void main(String[] args) {
        MaxContinuousSeriesOf1s obj = new MaxContinuousSeriesOf1s();
        ArrayList<Integer> list = new ArrayList<>();
        int[] arr = {1, 1, 0, 1, 1, 0, 0, 1, 1, 1};
        UniqueElements obj2 = new UniqueElements();
        obj2.addToList(list, arr);
        System.out.println(obj.maxone(list, 1));
    }
}
