package hashing;

import java.util.*;

/*Given a number A, find if it is COLORFUL number or not.
If number A is a COLORFUL number return 1 else, return 0.
What is a COLORFUL Number:

A number can be broken into different consecutive sequence of digits.
The number 3245 can be broken into sequences like 3, 2, 4, 5, 32, 24, 45, 324, 245 and 3245.
This number is a COLORFUL number, since the product of every consecutive sequence of digits is different
Input 1:
 A = 23
Input 2:
 A = 236
Output 1:
 1
Output 2:
 0
*/
public class ColorfulNumber {
    public int colorful(int A) {
        Set<Long> set = new HashSet<>();
        Queue<Long> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        while (A != 0) {
            list.add(0, A % 10);
            A /= 10;
        }
        queue.add(Long.valueOf(list.get(0)));
        for (int i: list) {
            if(!set.add((long) i)){
                return 0;
            }
        }
        for (int i = 1; i < list.size(); i++) {
            long num = list.get(i);
            int size = queue.size();
            queue.add(num);
            while (size > 0) {
                long num2 = queue.poll();
                long mul = num2 * num;
                if (!set.add(mul)) {
                    return 0;
                }
                queue.add(mul);
                size--;
            }
        }
        return 1;
    }
}
