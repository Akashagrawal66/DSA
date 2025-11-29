package sorting;

import java.util.ArrayList;

/*
Given an array of integers A of size N that is a permutation of [0, 1, 2, ..., (N-1)],
if we split the array into some number of "chunks" (partitions), and individually sort each chunk.
After concatenating them in order of splitting, the result equals the sorted array.

What is the most number of chunks we could have made?
*/
public class MaxChunksToMakeSorted {
    public int solve(ArrayList<Integer> A) {
        int chunks = 0;
        int maxInt = -1;
        for (int i = 0; i < A.size(); i++) {
            maxInt = Math.max(A.get(i), maxInt);
            if (i == maxInt) {
                chunks++;
            }
        }
        return chunks;
    }

    public static void main(String[] args) {
        MaxChunksToMakeSorted obj = new MaxChunksToMakeSorted();
        UniqueElements obj2 = new UniqueElements();
        ArrayList<Integer> A = new ArrayList<>();
        int[] arr = {1, 2, 3, 4, 0};
        obj2.addToList(A, arr);
        System.out.println(obj.solve(A));
    }

}
