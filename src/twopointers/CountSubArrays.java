package twopointers;

import sorting.UniqueElements;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
Misha likes finding all Subarrays of an Array.
Now she gives you an array A of N elements and told you to find the number of subarrays of A, that have unique elements.
Since the number of subarrays could be large, return value % 109 +7.

Input 1:
 A = [1, 1, 3]
Input 2:
 A = [2, 1, 2]
Output 1:
 4
Output 1:
 5
*/
public class CountSubArrays {
    public int solve(ArrayList<Integer> A) {
        int mod = (int) (1e9 + 7);
        Set<Integer> set = new HashSet<>();
        int result = 0;
        for (int i = 0, j = 0; i < A.size(); i++) {
            while (j < A.size()) {
                if (!set.add(A.get(j))) {
                    break;
                }
                j++;
            }
            result = (result + set.size()) % mod;
            set.remove(A.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        CountSubArrays obj = new CountSubArrays();
        ArrayList<Integer> list = new ArrayList<>();
        int[] arr = {93, 9, 12, 32, 97, 75, 32, 77, 40, 79, 61, 42, 57, 19, 64, 16, 86, 47, 41, 67, 76, 63, 24, 10, 25,
                96, 1, 30, 73, 91, 70, 65, 53, 75, 5, 19, 65, 6, 96, 33, 73, 55, 4, 90, 72, 83, 54, 78, 67, 56, 8, 70, 43, 63};
        UniqueElements obj2 = new UniqueElements();
        obj2.addToList(list, arr);
        System.out.println(obj.solve(list));
    }
}
