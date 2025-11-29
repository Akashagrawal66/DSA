package maths;

public class ModSum {

    public int solve(int[] A) {
        int M = (int)(1e9+7);
        int[] cnt = new int[1001];
        for (int i:A) {
            cnt[i]++;
        }
        int ans = 0;
        for (int i=1;i<=1000;i++) {
            for (int j=1;j<=1000;j++) {
                ans = (int) ((ans + (long) cnt[i] * cnt[j] * (i % j)) % M);
            }
        }
        return ans;
    }
}
