package queues;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;

/*Given an array of integers A and an integer B, we need to reverse the order of the first B elements of the array,
leaving the other elements in the same relative order.
NOTE: You are required to the first insert elements into an auxiliary queue then perform Reversal of first B elements.
Input 1:
 A = [1, 2, 3, 4, 5]
 B = 3
Input 2:
 A = [5, 17, 100, 11]
 B = 2
Output 1:
 [3, 2, 1, 4, 5]
Output 2:
 [17, 5, 100, 11]
*/
public class ReversingElementsOfQueue {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < B; i++) {
            deque.addFirst(A.get(i));
        }
        for (int i = 0; i < B; i++) {
            A.set(i, deque.poll());
        }
        return A;
    }
}
