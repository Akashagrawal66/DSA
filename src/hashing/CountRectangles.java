package hashing;

import sorting.UniqueElements;

import java.util.*;

/*
Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a
unique point (x, y) in a 2-D Cartesian plane.
Find and return the number of unordered quadruplet (i, j, k, l) such that (A[i], B[i]), (A[j], B[j]), (A[k], B[k])
and (A[l], B[l]) form a rectangle with the rectangle having all the sides parallel to either x-axis or y-axis.
Input 1:
 A = [1, 1, 2, 2]
 B = [1, 2, 1, 2]
Input 2:
 A = [1, 1, 2, 2, 3, 3]
 B = [1, 2, 1, 2, 1, 2]
Output 1:
 1
Output 2:
 3
*/
public class CountRectangles {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int count = 0;
        int n = A.size();
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int x = A.get(i);
            int y = B.get(i);
            set.add(Arrays.asList(x, y));
        }
        for (int i = 0; i < n; i++) {
            int x1 = A.get(i);
            int y1 = B.get(i);
            for (int j = i + 1; j < n; j++) {
                int x2 = A.get(j);
                int y2 = B.get(j);
                if (x1 != x2 && y1 != y2) {
                    List<Integer> point1 = Arrays.asList(x1, y2);
                    List<Integer> point2 = Arrays.asList(x2, y1);
                    if (set.contains(point2) && set.contains(point1)) {
                        count++;
                    }
                }
            }
        }
        return count/2;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        int[] arr1 = {1, 1, 2, 2, 3, 3};
        int[] arr2 = {1, 2, 1, 2, 1, 2};

        UniqueElements obj = new UniqueElements();
        obj.addToList(list1, arr1);
        obj.addToList(list2, arr2);

        CountRectangles obj2 = new CountRectangles();
        System.out.println(obj2.solve(list1, list2));
    }
}
