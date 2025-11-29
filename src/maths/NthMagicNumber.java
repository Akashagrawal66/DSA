package maths;

public class NthMagicNumber {
    public int solve(int A) {
        int ans = 0;
        int base = 5;
        while (A > 0) {
            if ((A & 1) == 1) {
                ans += base;
            }
            A >>= 1;
            base *= 5;
        }
        return ans;
    }
}
