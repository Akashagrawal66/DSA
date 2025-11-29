package strings;

import java.util.Arrays;

/*
Groot has a profound love for palindrome which is why he keeps fooling around with strings.
A palindrome string is one that reads the same backward as well as forward.

Given a string A of size N consisting of lowercase alphabets, he wants to know if it is possible to make the given string a
palindrome by changing exactly one of its character.
Input 1:
 A = "abbba"
Input 2:
 A = "adaddb"
Output 1:
 "YES"
Output 2:
 "NO"
*/
public class ClosetPalindrome {
    public String solve(String A) {
        int count = 0;
        int n = A.length();
        for (int i = 0; i < n / 2; i++) {
            if (A.charAt(i) != A.charAt(n - 1 - i)) {
                count++;
            }
        }
        if (count == 1 || ((n&1) == 1 && count == 0) ) {
            return "YES";
        }
        return "NO";
    }

    public static void main(String[] args) {
        String A = "abba";
        ClosetPalindrome obj = new ClosetPalindrome();
        System.out.println(obj.solve(A));
    }
}
