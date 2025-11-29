package strings;

/*
Given a string A of size N consisting only of lowercase alphabets.
The only operation allowed is to insert characters in the beginning of the string.
Find and return how many minimum characters are needed to be inserted to make the string a palindrome string.

Input 1:
 A = "abc"
Input 2:
 A = "bb"
Output 1:
 2
Output 2:
 0
*/
public class MakeStringPalindromes {
    public int solve(String A) {
        int start = 0;
        int end = A.length() - 1;
        int count = 0;
        while (start < end) {
            if (A.charAt(start) != A.charAt(end)) {
                count++;
                end--;
            } else {
                int num = checkIfPalindrome(A, start + 1, end - 1);
                if (num == (end - start - 1) / 2) {
                    break;
                } else {
                    count += (num + 1);
                    end -= (num + 1);
                }
            }
        }
        return count;
    }

    private int solveUsingLPSArray(String A) {
        int m = A.length();
        StringBuilder sb = new StringBuilder(A);
        A = A + "$" + sb.reverse();
        int n = A.length();
        int i = 1, len = 0;
        int[] lps = new int[n];
        while (i < n) {
            if (A.charAt(i) == A.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    len = lps[len - 1];
                }
            }
        }
        return m - lps[n - 1];
    }


    private int checkIfPalindrome(String A, int start, int end) {
        int count = 0;
        while (start < end) {
            if (A.charAt(start) != A.charAt(end)) {
                return count;
            }
            count++;
            start++;
            end--;
        }
        return count;
    }

    public static void main(String[] args) {
        MakeStringPalindromes obj = new MakeStringPalindromes();
        String A = "babc";
        System.out.println(obj.solve(A));
        System.out.println(obj.solveUsingLPSArray(A));
    }
}
