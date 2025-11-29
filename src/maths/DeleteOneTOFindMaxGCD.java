package maths;

public class DeleteOneTOFindMaxGCD {
    public int solve(int[] A) {
        int n = A.length;
        int[] prefixGcd = new int[n];
        int[] suffixGcd = new int[n];
        int currentGcd = 0;
        int currGcd = 0;
        for (int i = 0; i < n; i++) {
            currentGcd = gcd(currentGcd, A[i]);
            prefixGcd[i] = currentGcd;
            currGcd = gcd(currGcd, A[n - 1 - i]);
            suffixGcd[n - 1 - i] = currGcd;
        }
        int maxGcd = 0;
        for (int i = 0; i < n; i++) {
            int prefix = i == 0 ? 0 : prefixGcd[i - 1];
            int suffix = i == n - 1 ? 0 : suffixGcd[i + 1];
            maxGcd = Math.max(maxGcd, gcd(prefix, suffix));
        }
        return maxGcd;
    }

    private int gcd(int a, int b) {
        while (a != 0 && b != 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }
        return Math.max(a, b);
    }

    public static void main(String[] args) {
        DeleteOneTOFindMaxGCD obj = new DeleteOneTOFindMaxGCD();
        int[] A = {12, 15, 18};
        System.out.println(obj.solve(A));
    }
}
