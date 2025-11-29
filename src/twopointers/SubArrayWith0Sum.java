package twopointers;

import sorting.UniqueElements;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
Given an array of integers A, find and return whether the given array contains a non-empty subArray with a sum equal to 0.
If the given array contains a sub-array with sum zero return 1, else return 0.
Input 1:
 A = [1, 2, 3, 4, 5]
Input 2:
 A = [4, -1, 1]
Output 1:
 0
Output 2:
 1
*/
public class SubArrayWith0Sum {
    public int solve(ArrayList<Integer> A) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        int result = 0;
        for (int i : A) {
            sum += i;
            System.out.println(sum);
            if (!set.add(sum) || sum == 0) {
                result = 1;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SubArrayWith0Sum obj = new SubArrayWith0Sum();
        ArrayList<Integer> list = new ArrayList<>();
        UniqueElements obj2 = new UniqueElements();
        int[] arr = {1, 2, 3, 4, 5};
        obj2.addToList(list, arr);
        System.out.println(obj.solve(list));
    }
}
