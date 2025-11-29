package twopointers;

import java.util.*;

/*
Given an unsorted integer array A of size N.
Find the length of the longest set of consecutive elements from array A.
Input 1:
A = [100, 4, 200, 1, 3, 2]
Input 2:
A = [2, 1]
Output 1:
 4
Output 2:
 2
*/
public class LongestConsecutiveSequence {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int longestConsecutive(final List<Integer> A) {
        Set<Integer> set = new HashSet<>(A);
        int max = 0;
        for (int i : A) {
            if (!set.contains(i - 1)) {
                int count = 0;
                while (set.contains(i)) {
                    count++;
                    i++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5);
        LongestConsecutiveSequence obj = new LongestConsecutiveSequence();
        System.out.println(obj.longestConsecutive(list));
    }
}
