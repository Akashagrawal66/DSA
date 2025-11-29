package queues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
Given an integer, A. Find and Return first positive A integers in ascending order containing only digits 1, 2, and 3.
NOTE: All the A integers will fit in 32-bit integers.
Input 1:
 A = 3
Input 2:
 A = 7
Output 1:
 [1, 2, 3]
Output 2:
 [1, 2, 3, 11, 12, 13, 21]
*/
public class NIntsContaining12And3 {
    public ArrayList<Integer> solve(int A) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        while (result.size() != A) {
            int num = queue.poll();
            result.add(num);
            for(int i=1;i<=3;i++) {
                queue.add(num*10+i);
            }
        }
        return result;
    }
}
