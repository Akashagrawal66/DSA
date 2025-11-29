package array;

public class MinSwaps {

    public int solve(int[] A) {
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            while (A[i] != i) {
                int temp = A[i];
                A[i] = A[temp];
                A[temp] = temp;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MinSwaps obj = new MinSwaps();
        int[] A = {3, 0, 1, 2};
        System.out.println(obj.solve(A));
    }
}
