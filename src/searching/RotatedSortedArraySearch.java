package searching;

import java.util.List;

/*
Given a sorted array of integers A of size N and an integer B,
where array A is rotated at some pivot unknown beforehand.

For example, the array [0, 1, 2, 4, 5, 6, 7] might become [4, 5, 6, 7, 0, 1, 2].
Your task is to search for the target value B in the array.
If found, return its index; otherwise, return -1.
You can assume that no duplicates exist in the array.

NOTE: You are expected to solve this problem with a time complexity of O(log(N)).*/
public class RotatedSortedArraySearch {
    public int search(final List<Integer> A, int B) {
        int index = findPivot(A);
        System.out.println(index);
        int n = A.size();
        if (B >= A.get(index) && B <= A.get(n-1)) {
            return binarySearch(A, index, n-1, B);
        }
        return binarySearch(A, 0, index-1, B);
    }

    private int findPivot(List<Integer> a) {
        int n = a.size() - 1;
        int start = 0;
        int end = n - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (a.get(mid) <= a.get(n - 1)) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return start;
    }

    private int binarySearch(List<Integer> a, int start, int end, int B) {
        System.out.println(start+" "+end);
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (a.get(mid) < B) {
                start = mid + 1;
            } else if (a.get(mid) > B) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        RotatedSortedArraySearch obj = new RotatedSortedArraySearch();
        List<Integer> A = List.of( 2, 3, 32, 57, 69, 74, 81, 99, 100);
        System.out.println(obj.search(A, 100));
    }
}
