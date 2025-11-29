package queues;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*Imagine you're a teacher. You ask students to call out a letter one by one. After each letter, you jot down the very
first letter that's only been called out once. If all letters have been repeated, you write "#".

Here's a scenario:

A student says "a". It's the first letter. You write "a".
Next, a student says "b", "a" is still unique, so you add "a". Now it's "aa".
A student says "a" again. Now, "b" is the unique one. You add "b", making it "aab".
A student says "b". All letters so far are repeated. You add "#". It becomes "aab#".
A student says "c". "c" is unique. You add "c". The final is "aab#c".
Your task? Given the sequence the students call out A, determine the string on the board.
Input 1:
 A = "abadbc"
Input 2:
 A = "abcabc"
Output 1:
"aabbdd"
Output 2:
"aaabc#"
*/
public class UniqueLetter {
    public String solve(String A) {
        Queue<Character> queue = new LinkedList<>();
        Set<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < A.length()) {
            char ch = A.charAt(i);
            if (queue.isEmpty()) {
                if (set.contains(ch)) {
                    sb.append('#');
                } else {
                    set.add(ch);
                    queue.add(ch);
                    sb.append(ch);
                }
                i++;
            } else {
                if (queue.peek() == ch) {
                    queue.poll();
                } else {
                    sb.append(queue.peek());
                    if (set.contains(ch)) {
                        queue.remove(ch);
                    } else {
                        queue.add(ch);
                        set.add(ch);
                    }
                    i++;
                }
            }
        }
        return sb.toString();
    }
}
