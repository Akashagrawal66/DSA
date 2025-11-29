package strings;

/*
You are given a string A. Find the number of substrings that start and end with 'a'.
Input 1:
 A = "aab"
Input 2:
 A = "bcbc"
Output 1:
 3
Output 2:
 0
*/
public class CountA {
    public int solve(String A) {
        int count = 0;
        int result = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'a') {
                count++;
                result += count;
            }
        }
        return result;
    }
}
