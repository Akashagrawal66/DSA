package array;

public class MaxAbsDifference {
    public int solve(int[] A) {
        int ans = 0;
        int xMin = Integer.MAX_VALUE;
        int yMin = Integer.MAX_VALUE;
        int xMax = Integer.MIN_VALUE;
        int yMax = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            xMin = Math.min(xMin, A[i] - i);
            xMax = Math.max(xMax, A[i] - i);
            yMin = Math.min(yMin, A[i] + i);
            yMax = Math.max(yMax, A[i] + i);
            ans = Math.max(ans, Math.max((xMax - xMin), (yMax - yMin)));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, -1};
        MaxAbsDifference obj = new MaxAbsDifference();
        System.out.println(obj.solve(A));
    }
}
