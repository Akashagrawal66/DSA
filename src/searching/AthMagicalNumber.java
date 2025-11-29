package searching;

import java.util.ArrayList;
import java.util.List;

/*
You are given three positive integers, A, B, and C.
Any positive integer is magical if divisible by either B or C.
Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.

Note: Ensure to prevent integer overflow while calculating.
Input 1:
 A = 1
 B = 2
 C = 3
Input 2:
 A = 4
 B = 2
 C = 3
Example Output
Output 1:
 2
Output 2:
 6
*/
public class AthMagicalNumber {
    public int solve(int A, int B, int C) {
        int gcd = gcd(B, C);
        int mod = (int) (1e9 + 7);
        long start = Math.min(B, C);
        long end = ((long) Math.max(B, C) * A);
        long lcm = ((long) B * C) / gcd;
        while (start < end) {
            long mid = (start + (end - start) / 2);
            if ((mid / B + mid / C - mid / lcm) < A) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return (int) (start % mod);
    }

    private int gcd(int b, int c) {
        if (b < 1) {
            return c;
        } else if (b == 1) {
            return b;
        }
        return gcd(c % b, b);
    }

    public static void main(String[] args) {
        AthMagicalNumber obj = new AthMagicalNumber();

        System.out.println(obj.solve(807414236, 3788, 38141));
        System.out.println(((Integer.MAX_VALUE / 12 + 12) / 2) % (int) (1e9 + 7));
    }
}
