package hashing;

import sorting.UniqueElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
Given two arrays of integers A and B describing a pair of (A[i], B[i]) coordinates in a 2D plane.
A[i] describe x coordinates of the ith point in the 2D plane, whereas B[i] describes the y-coordinate of the ith point in the 2D plane.
Find and return the maximum number of points that lie on the same line.
Input 1:
 A = [-1, 0, 1, 2, 3, 3]
 B = [1, 0, 1, 2, 3, 4]
Input 2:
 A = [3, 1, 4, 5, 7, -9, -8, 6]
 B = [4, -8, -3, -2, -1, 5, 7, -4]
Output 1:
 4
Output 2:
 2
*/
public class PointsOnSameLine {

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        return maxpointsonsameline(A, B);
    }

    public int __gcd(int x, int y) {
        if (x == 0)
            return y;
        return __gcd(y % x, x);
    }

    public int maxpointsonsameline(ArrayList<Integer> x, ArrayList<Integer> y) {
        int n = x.size();
        if (n < 3)
            return n;
        int ans = 0;
        int curmax, overlap, vertical;
        for (int i = 0; i < n; ++i) {
            curmax = 0;
            overlap = 0;
            vertical = 0;
            Map<ArrayList<Integer>, Integer> mp = new HashMap<>();
            for (int j = i + 1; j < n; ++j) {
                if (Objects.equals(x.get(i), x.get(j)) && Objects.equals(y.get(i), y.get(j)))
                    ++overlap;
                else if (Objects.equals(x.get(i), x.get(j)))
                    ++vertical;
                else {
                    int xdiff = x.get(j) - x.get(i);
                    int ydiff = y.get(j) - y.get(i);
                    int z = __gcd(xdiff, ydiff);
                    xdiff /= z;
                    ydiff /= z;
                    ArrayList<Integer> tmp = new ArrayList<>();
                    tmp.add(xdiff);
                    tmp.add(ydiff);
                    // mp stores the slope of the line between i-th and j-th point
                    mp.put(tmp, mp.getOrDefault(tmp, 0) + 1);
                    curmax = Math.max(curmax, mp.get(tmp));
                }
                curmax = Math.max(curmax, vertical);
            }
            System.out.println("Vertical: "+vertical+" Overlap: "+overlap);
            ans = Math.max(ans, curmax + overlap + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        UniqueElements obj = new UniqueElements();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        int[] arr1 = {48, 45, -3, 7, -25, 38, 2, 13, 13, 18, -44, 34, -27, -46, 48, -39, -41, -32, -16, 17, -6, 44, -28, -44, -6, -43, -16, 30, -3, -27, 32, 38, -26, 20, 4, -44, -37};
        int[] arr2 = {47, -42, 41, 22, -4, -35, -45, -22, 5, -20, 21, -13, 47, 32, -48, 47, 17, -23, 30, -30, 37, 42, 44, 23, 1, -40, -9, 34, -34, 49, 16, -35, 2, -19, 31, 23, -37};
        obj.addToList(list1, arr1);
        obj.addToList(list2, arr2);
        PointsOnSameLine obj2 = new PointsOnSameLine();
        System.out.println(obj2.solve(list1, list2));
    }
}
