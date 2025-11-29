package twopointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
Shaggy has an array A consisting of N elements. We call a pair of distinct indices in that array a special if
elements at those indices in the array are equal.
Shaggy wants you to find a special pair such that the distance between that pair is minimum. Distance between two
indices is defined as |i-j|. If there is no special pair in the array, then return -1.
Input 1:
A = [7, 1, 3, 4, 1, 7]
Input 2:
A = [1, 1]
Output 1:
 3
Output 2:
 1
*/
public class ShaggyAndDistances {
    public int solve(ArrayList<Integer> A) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = A.size() + 1;
        for (int i = 0; i < A.size(); i++) {
            int num = A.get(i);
            if (map.containsKey(num)) {
                result = Math.min(result, i - map.get(num));
            }
            map.put(num, i);
        }
        return result;
    }
}
