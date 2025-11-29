package stack;

import java.util.ArrayList;
import java.util.Stack;

/*
There is a football event going on in your city. In this event, you are given A passes and players having ids between 1 and 106.
Initially, some player with a given id had the ball in his possession. You have to make a program to display the id of the player
who possessed the ball after exactly A passes.
There are two kinds of passes:
1) ID
2) 0
For the first kind of pass, the player in possession of the ball passes the ball "forward" to the player with id = ID.
For the second kind of pass, the player in possession of the ball passes the ball back to the player who had forwarded the ball to him.
In the second kind of pass "0" just means Back Pass.
Return the ID of the player who currently possesses the ball.
Input 1:
 A = 10
 B = 23
 C = [86, 63, 60, 0, 47, 0, 99, 9, 0, 0]
Input 2:
 A = 1
 B = 1
 C = [2]
Output 1:
 63
Output 2:
 2
*/
public class PassingGame {
    public int solve(int A, int B, ArrayList<Integer> C) {
        Stack<Integer> stack = new Stack<>();
        stack.push(B);
        for (Integer num : C) {
            if (num == 0) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }
        return stack.peek();
    }
}
