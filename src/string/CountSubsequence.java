package string;

import java.util.ArrayList;
import java.util.List;

public class CountSubsequence {
    public static void main(String[] args) {
        CountSubsequence subsequence = new CountSubsequence();
        String str = "dagerraikgagg";
        System.out.println(subsequence.solve(str));
    }

    public int solve(String str) {
        String find = "ag";
        int count = 0;
        int result = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);

            if (ch == 'g') {
                count++;
            } else if (ch == 'a') {
                result += count;
            }
        }
        return result;
    }
}
