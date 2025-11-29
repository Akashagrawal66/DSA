package searching;

import sorting.UniqueElements;

import java.util.ArrayList;

/*
You are given a sorted array A of size N and a target value B.
Your task is to find the index (0-based indexing) of the target value in the array.

If the target value is present, return its index.
If the target value is not found, return the index of least element greater than equal to B.
If the target value is not found and least number greater than equal to target is also not present, return the length of array (i.e. the position where target can be placed)
Your solution should have a time complexity of O(log(N)).
*/
public class SortedInsertPosition {
    public int searchInsert(ArrayList<Integer> A, int B) {
        return binarySearch(A, B, 0, A.size() - 1);
    }

    private int binarySearch(ArrayList<Integer> A, int B, int start, int end) {
        if (start == A.size() || (start == end && A.get(start) < B)) {
            return A.size();
        } else if (start == end) {
            return start;
        }
        int mid = start + (end - start) / 2;
        if (A.get(mid) < B) {
            return binarySearch(A, B, mid + 1, end);
        } else if (A.get(mid) > B) {
            return binarySearch(A, B, start, mid);
        }
        return mid;
    }

    public static void main(String[] args) {
        SortedInsertPosition obj = new SortedInsertPosition();
        UniqueElements obj2 = new UniqueElements();
        ArrayList<Integer> A = new ArrayList<>();
        int[] arr = {1, 3, 5, 6};
        obj2.addToList(A, arr);
        System.out.println(obj.searchInsert(A, -10));
    }
}
