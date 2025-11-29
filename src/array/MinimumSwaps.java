package array;

public class MinimumSwaps {
    public int minSwaps(int[] A, int B) {
        int count = 0;
        for (int i : A) {
            if (i <= B) {
                count++;
            }
        }
        int numsGreaterThanB = 0;
        for (int i = 0; i < count; i++) {
            if (A[i] > B) {
                numsGreaterThanB++;
            }
        }
        int ans = numsGreaterThanB;
        for (int i = 0, j = count; j < A.length; i++, j++) {
            if (A[i] > B) {
                numsGreaterThanB--;
            }
            if (A[j] > B) {
                numsGreaterThanB++;
            }
            ans = Math.min(ans, numsGreaterThanB);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {12, 1, 9, 13, 3, 10, 18, 4};
        int B = 8;
        MinimumSwaps obj = new MinimumSwaps();
        System.out.println(obj.minSwaps(A, B));
    }
}
