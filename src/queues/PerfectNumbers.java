package queues;

import java.util.LinkedList;
import java.util.Queue;

/*Given an integer A, you have to find the Ath Perfect Number.

A Perfect Number has the following properties:

It comprises only 1 and 2.
The number of digits in a Perfect number is even.
It is a palindrome number.
For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.
Input 1:
 A = 2
Input 2:
 A = 3
Output 1:
 22
Output 2:
 1111
*/
public class PerfectNumbers {
    public String solve(int A) {
        if (A == 1) {
            return "11";
        } else if (A == 2) {
            return "22";
        }
        Queue<String> queue = new LinkedList<>();
        int count = 0;
        queue.add("11");
        queue.add("22");
        count += 2;
        String result = "";
        while (count != A) {
            String str = queue.poll();
            for (int i = 1; i <= 2 && (count != A); i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(str.substring(0, str.length()/2))
                        .append(i).append(i).append(str.substring(str.length()/2));
                queue.add(sb.toString());
                count++;
                if (count == A) {
                    result = sb.toString();
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PerfectNumbers obj = new PerfectNumbers();
        System.out.println(obj.solve(11));
    }
}
