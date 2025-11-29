package searching;

import sorting.UniqueElements;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
There are two sorted arrays A and B of sizes N and M respectively.
Find the median of the two sorted arrays (The median of the array formed by merging both the arrays).
NOTE:
The overall run time complexity should be O(log(m+n)).
IF the number of elements in the merged array is even, then the median is the average of (n/2)th and (n/2+1)th element.
For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5.
*/
public class MedianOfArray {
    public double findMedianSortedArrays(final List<Integer> A, final List<Integer> B) {
        int n1 = A.size();
        int n2 = B.size();
        int n = n1+n2;
        if(n1 > n2) {
            return findMedianSortedArrays(B, A);
        }
        int left = (n1+n2+1)/2;
        int low = 0, high = n1;
        while (low <= high) {
            int cut1 = (low+high)>>1;
            int cut2 = left - cut1;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            if(cut1 < n1 ) r1 = A.get(cut1);
            if(cut2 < n2) r2 = B.get(cut2);
            if(cut1-1 >= 0) l1 = A.get(cut1-1);
            if(cut2-1 >= 0) l2 = B.get(cut2-1);
            if(l1 <= r2 && l2 <= r1) {
                if((n&1) == 1) {
                    return Math.max(l1, l2);
                } else {
                    return (Math.max(l1, l2) + Math.min(r1, r2) )/ 2.0;
                }
            } else if (l1 > r2) {
                high = cut1-1;
            } else {
                low = cut1+1;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        MedianOfArray obj = new MedianOfArray();
        UniqueElements obj2 = new UniqueElements();
        ArrayList<Integer> A = new ArrayList<>();
        int[] arr = {1,4,5};
        ArrayList<Integer> B = new ArrayList<>();
        int[] arr2 = {2,3};
        obj2.addToList(A, arr);
        obj2.addToList(B, arr2);
        System.out.println(obj.findMedianSortedArrays(A, B));
    }
}
