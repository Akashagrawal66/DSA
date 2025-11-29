package searching;

import sorting.UniqueElements;

import java.util.ArrayList;

/*
Given an array of integers A, find and return the peak element in it.
An array element is considered a peak if it is not smaller than its neighbors.
For corner elements, we need to consider only one neighbor.

It is guaranteed that the array contains only a single peak element.
Users are expected to solve this in O(log(N)) time. The array may contain duplicate elements.

*/
public class FindPeakElement {
    public int solve(ArrayList<Integer> A) {
        return binarySearch(A, 0, A.size()-1);
    }
    private int binarySearch(ArrayList<Integer> A, int start, int end) {
        if (start >= end) {
            return A.get(start);
        }
        int mid = (start + end) / 2;
        if(mid == start) {
            return A.get(mid)>A.get(mid+1)?A.get(mid):A.get(mid+1);
        }else if (A.get(mid) > A.get(mid-1) && A.get(mid) < A.get(mid+1)) {
            return binarySearch(A, mid + 1, end);
        } else if (A.get(mid) < A.get(mid-1) && A.get(mid) > A.get(mid+1)) {
            return binarySearch(A, start, mid-1);
        }
        return A.get(mid);
    }

    public static void main(String[] args) {
        FindPeakElement obj = new FindPeakElement();
        UniqueElements uniqueElements = new UniqueElements();
        ArrayList<Integer> A = new ArrayList<>();
        int[] arr = {2,3,8,1,2};
        uniqueElements.addToList(A, arr);
        System.out.println(obj.solve(A));
    }
}
