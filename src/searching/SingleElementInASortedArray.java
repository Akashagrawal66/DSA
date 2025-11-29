package searching;

import sorting.UniqueElements;

import java.util.ArrayList;
import java.util.Objects;

/*
Given a sorted array of integers A where every element appears twice except for one element
which appears once, find and return this single element that appears only once.
Elements which are appearing twice are adjacent to each other.
NOTE: Users are expected to solve this in O(log(N)) time.
*/
public class SingleElementInASortedArray {
    public int solve(ArrayList<Integer> A) {
        return binarySearch(A, 0, A.size() - 1);
    }

    private int binarySearch(ArrayList<Integer> A, int start, int end) {
        if (start == end) {
            return A.get(start);
        }
        int mid = start + (end - start) / 2;
        if ((mid & 1) == 1 && (mid + 1) < A.size() && Objects.equals(A.get(mid), A.get(mid + 1)) ||
                (mid & 1) == 0 && (mid - 1) >= 0 && Objects.equals(A.get(mid), A.get(mid - 1))) {
            return binarySearch(A, start, mid - 1);
        } else if ((mid & 1) == 1 && (mid - 1) >= 0 && Objects.equals(A.get(mid), A.get(mid - 1)) ||
                (mid & 1) == 0 && (mid + 1) < A.size() && Objects.equals(A.get(mid), A.get(mid + 1))) {
            return binarySearch(A, mid + 1, end);
        }
        return A.get(mid);
    }

    public static void main(String[] args) {
        UniqueElements obj2 = new UniqueElements();
        ArrayList<Integer> A = new ArrayList<>();
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6};
        obj2.addToList(A, arr);
        SingleElementInASortedArray obj = new SingleElementInASortedArray();
        System.out.println(obj.solve(A));
    }
}
