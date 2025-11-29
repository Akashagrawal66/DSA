package strings;

import java.util.Arrays;

/*
You are given a string A of lowercase English alphabets. Rearrange the characters of the given string A such that there is no boring substring in A.
A boring substring has the following properties:
Its length is 2.
Both the characters are consecutive, for example - "ab", "cd", "dc", "zy" etc.(If the first character is C then the next character can be either (C+1) or (C-1)).
Return 1 if it is possible to rearrange the letters of A such that there are no boring substrings in A else, return 0.

Input 1:
 A = "abcd"
Input 2:
 A = "aab"
Output 1:
 1
Output 2:
 0
*/
public class BoringSubString {
    public int solve(String A) {
        int[] arr = new int[26];
        for (int i = 0; i < A.length(); i++) {
            arr[A.charAt(i) - 'a']++;
        }
        char firstEven = 0;
        char firstOdd = 0;
        char lastOdd = 0;
        char lastEven = 0;
        boolean firstE = false;
        boolean firstO = false;
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                if ((i & 1) == 0) {
                    if (!firstE) {
                        firstEven = (char) (i + 'a');
                        firstE = true;
                    }
                    lastEven = (char) (i + 'a');
                } else {
                    if (!firstO) {
                        firstOdd = (char) (i + 'a');
                        firstO = true;
                    }
                    lastOdd = (char) (i + 'a');
                }
            }
        }
        if ((Math.abs(lastEven - firstOdd) != 1) || (Math.abs(lastOdd - firstEven) != 1)) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        BoringSubString obj = new BoringSubString();
        System.out.println(obj.solve("abcdeffe"));
    }
}
