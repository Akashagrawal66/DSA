package queues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
A CPU has N tasks to be performed. It is to be noted that the tasks have to be completed in a specific order to avoid deadlock.
In every clock cycle, the CPU can either perform a task or move it to the back of the queue. You are given the current state of the
scheduler queue in array A and the required order of the tasks in array B.
Determine the minimum number of clock cycles to complete all the tasks.
Input 1:
A = [2, 3, 1, 5, 4]
B = [1, 3, 5, 4, 2]
Input 2:
A = [1]
B = [1]
Output 1:
 10
Output 2:
 1
*/
public class TaskScheduling {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        Queue<Integer> queue = new LinkedList<>(A);
        int j = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            if (num != B.get(j))  {
                queue.add(num);
            } else {
                j++;
            }
            count++;
        }
        return count;
    }
}
