package strings;

/*
Given 2 strings A and B of size N and M respectively consisting of lowercase alphabets,
find the lexicographically smallest string that can be formed by concatenating non-empty prefixes of A and B (in that order).

Note: The answer string has to start with a non-empty prefix of string A followed by a non-empty prefix of string B.
Input 1:

 A = "abba"
 B = "cdd"
Input 2:

 A = "acd"
 B = "bay"


Example Output

Output 1:

 "abbac"
Output 2:

 "ab"
*/
public class SmallestPrefixString {
    public String smallestPrefix(String A, String B) {
        StringBuilder sb = new StringBuilder();
        sb.append(A.charAt(0));
        char ch = B.charAt(0);
        for (int i = 1; i < A.length(); i++) {
            char ch1 = A.charAt(i);
            if (ch1 < ch) {
                sb.append(ch1);
            } else {
                break;
            }
        }
        sb.append(ch);
        return sb.toString();
    }
}
