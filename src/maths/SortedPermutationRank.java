package maths;

public class SortedPermutationRank {
    public int findRank(String A) {
        int n = A.length();
        int ans = 0;
        for(int i=0;i<n-1;i++) {
            int count = 0;
            for(int j = i+1;j<n;j++) {
                if(A.charAt(j) < A.charAt(i)) {
                    count++;
                }
            }
            ans = ((ans + count*fact(n-i-1))%1000003);
        }
        return (ans+1);
    }
    private int fact(int n) {
        if(n ==0 || n == 1) {
            return 1;
        }
        return (int)(((long)n*fact(n-1))%1000003);
    }
}
