package strings;

/*
You are given a string A of length N consisting of lowercase alphabets. Find the period of the string.
Period of the string is the minimum value of k (k >= 1), that satisfies A[i] = A[i % k] for all valid i.
Input 1:
 A = "abababab"
Input 2:
 A = "aaaa"
Output 1:
 2
Output 2:
 1
*/
public class PeriodOfAString {
    public int solve(String A) {
        int n = A.length();
        int[] zarr = new int[n];
        zarr[0] = n;
        int l = 0, r = 0;
        int ans = n;
        for (int i = 1; i < n; i++) {
            if (i > r) {
                l = r = i;
                while (r < n && A.charAt(r) == A.charAt(r - l)) {
                    r++;
                }
                zarr[i] = r - l;
                r--;
            } else {
                if (zarr[i - l] < r - l + 1) {
                    zarr[i] = zarr[i - l];
                } else {
                    l = i;
                    while (r < n && A.charAt(r) == A.charAt(r - l)) {
                        r++;
                    }
                    zarr[i] = r - l;
                    r--;
                }
            }
            if ( i + zarr[i] == n) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String A = "abababababb";
        PeriodOfAString obj = new PeriodOfAString();
        System.out.println(obj.solve(A));
    }
}
