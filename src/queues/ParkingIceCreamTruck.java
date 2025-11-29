package queues;

import java.util.*;

/*
Imagine you're an ice cream truck driver in a beachside town. The beach is divided into several sections, and each section has
varying numbers of beachgoers wanting ice cream given by the array of integers A.
For simplicity, let's say the beach is divided into 8 sections. One day, you note down the number of potential customers in each section:
 [5, 12, 3, 4, 8, 10, 2, 7]. This means there are 5 people in the first section, 12 in the second, and so on.
You can only stop your truck in B consecutive sections at a time because of parking restrictions. To maximize sales,
you want to park where the most customers are clustered together.
For all B consecutive sections, identify the busiest stretch to park your ice cream truck and serve the most customers.
Return an array C, where C[i] is the busiest section in each of the B consecutive sections. Refer to the given example for clarity.
NOTE: If B > length of the array, return 1 element with the max of the array.
Input 1:
 A = [1, 3, -1, -3, 5, 3, 6, 7]
 B = 3
Input 2:
 A = [1, 2, 3, 4, 2, 7, 1, 3, 6]
 B = 6
Output 1:
 [3, 3, 5, 5, 6, 7]
Output 2:
 [7, 7, 7, 7]
*/
public class ParkingIceCreamTruck {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        Deque<Integer> deque = new ArrayDeque<>();
        int n = A.size();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < B && i < n; i++) {
            int num = A.get(i);
            while (!deque.isEmpty() && A.get(deque.peekLast()) <= num) {
                deque.pollLast();
            }
            deque.add(i);
        }
        result.add(A.get(deque.peek()));
        for (int j = B; j < n; j++) {
            int indexToBeRemoved = j - B;
            int numToBeConsidered = A.get(j);
            if (!deque.isEmpty() && indexToBeRemoved == deque.peek()) {
                deque.poll();
            }
            while (!deque.isEmpty() && A.get(deque.peekLast()) <= numToBeConsidered) {
                deque.pollLast();
            }
            deque.add(j);
            result.add(A.get(deque.peek()));
        }
        return result;
    }
}
