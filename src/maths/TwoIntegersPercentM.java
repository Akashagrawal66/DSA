package maths;

public class TwoIntegersPercentM {
    public int solve(int A, int B) {
        return Math.abs(B - A);
    }

    public int solvePowerModulo(int A, int B) {
        int ans = 1;
        int mod = (int) (1e9+7);
        A = A%mod;
        for (int i = 1; i <= B; i++) {
            ans = (int) (((long) ans * A)%mod);
        }
        return ans;
    }

    public static void main(String[] args) {
        TwoIntegersPercentM obj = new TwoIntegersPercentM();
        int A = 2;
        int B = 33;
        System.out.println(obj.solve(A, B));
        System.out.println(obj.solvePowerModulo(A, B));
    }
}
