package hashing;

import sorting.UniqueElements;

import java.util.*;

/*
Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y)
in 2D Cartesian plane.
Find and return the number of unordered triplets (i, j, k) such that (A[i], B[i]), (A[j], B[j]) and (A[k], B[k])
form a right-angled triangle with the triangle having one side parallel to the x-axis and one side parallel to the y-axis.

NOTE: The answer may be large so return the answer modulo (109 + 7).

Input 1:
 A = [1, 1, 2]
 B = [1, 2, 1]
Input 2:
 A = [1, 1, 2, 3, 3]
 B = [1, 2, 1, 2, 1]
Output 1:
 1
Output 2:
 6
*/
public class CountRightTriangles {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        Map<Integer, Integer> xMap = new HashMap<>();
        Map<Integer, Integer> yMap = new HashMap<>();
        int n = A.size();
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            xMap.put(A.get(i), xMap.getOrDefault(A.get(i), 0) + 1);
            yMap.put(B.get(i), yMap.getOrDefault(B.get(i), 0) + 1);
        }
        int mod = (int) (1e9 + 7);
        int count = 0;
        for (int i = 0; i < n; i++) {
            int x = A.get(i);
            int y = B.get(i);
            List<Integer> list = new ArrayList<>();
            list.add(x);
            list.add(y);
            if (set.add(list)) {
//            System.out.println(x+" "+y);
                int numX = xMap.get(x);
                int numY = yMap.get(y);
//            System.out.println(numX+" "+numY);
                if (numX > 1 && numY > 1) {
                    count = (int) ((count + ((long) (numX - 1) * (numY - 1)) % mod) % mod);
                }
            }
        }
        return count;
    }

    public int solve(int[] A, int[] B) {
        int n = A.length;
        int mod = (int) 1e9 + 7;
        long result = 0;
        Map<Integer, Integer> hm1 = new HashMap<>();
        Map<Integer, Integer> hm2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hm1.put(A[i], hm1.getOrDefault(A[i], 0) + 1);
            hm2.put(B[i], hm2.getOrDefault(B[i], 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            int countX = hm1.get(A[i]) - 1;
            int countY = hm2.get(B[i]) - 1;
            ;
            result = (result + 1L * countX * countY) % mod;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        int[] arr1 = {1, 1, 1, 2};
        int[] arr2 = {1, 1, 2, 1};

        UniqueElements obj = new UniqueElements();
        obj.addToList(list1, arr1);
        obj.addToList(list2, arr2);

        CountRightTriangles obj2 = new CountRightTriangles();
        System.out.println(obj2.solve(list1, list2));
        System.out.println(obj2.solve(arr1, arr2));
    }
}
