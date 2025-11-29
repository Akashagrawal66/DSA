package strings;

/*
Given two binary strings A and B, count how many cyclic shift of B when taken XOR with A give 0.
NOTE: If there is a string, S0, S1, ... Sn-1 , then it is a cyclic shift is of the form Sk, Sk+1, ... Sn-1, S0, S1, ... Sk-1
where k can be any integer from 0 to N-1.
Input 1:
 A = "1001"
 B = "0011"
Input 2:
 A = "111"
 B = "111"
Output 1:
 1
Output 2:
 3
*/
public class CyclicPermutations {
    public int solve(String A, String B) {
        String str = A + "$" + B + B.substring(0, B.length() - 1);
        int n = str.length();
        int m = A.length();
        int[] zarr = new int[n];
        zarr[0] = n;
        int l = 0, r = 0;
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (i > r) {
                l = r = i;
                while (r < n && str.charAt(r) == str.charAt(r - l)) {
                    r++;
                }
                zarr[i] = r - l;
                r--;
            } else {
                if (zarr[i - l] < r - i + 1) {
                    zarr[i] = zarr[i - l];
                } else {
                    l = i;
                    while (r < n && str.charAt(r) == str.charAt(r - l)) {
                        r++;
                    }
                    zarr[i] = r - l;
                    r--;
                }
            }
            if (zarr[i] == m) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String A = "111";
        String B = "111";

        CyclicPermutations obj = new CyclicPermutations();
        System.out.println(obj.solve(A, B));
    }
}
