package array;

public class RainWaterTrapped {
    public int trap(final int[] A) {
        int n = A.length;
        int[] rightMax = new int[n];
        rightMax[n-1] = A[n-1];
        for(int i=n-2;i>=0;i--) {
            rightMax[i] = Math.max(A[i], rightMax[i+1]);
        }
        int leftMax = A[0];
        int ans = 0;
        for(int i=1;i<n-1;i++) {
            leftMax = Math.max(leftMax, A[i]);
            ans += (Math.min(leftMax, rightMax[i]) - A[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
//                 0,0,1,0,1,2,1,0,0,
        RainWaterTrapped obj = new RainWaterTrapped();
        System.out.println(obj.trap(A));
    }
}
