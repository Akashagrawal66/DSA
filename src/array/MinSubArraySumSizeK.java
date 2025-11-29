package array;

public class MinSubArraySumSizeK {

    public int solve(int[] arr, int k) {
        int sum = 0;
        for(int i=0;i<k;i++) {
            sum += arr[i];
        }
        int minSum = sum;
        for(int j=k;j<arr.length;j++) {
            sum = (sum - arr[j-k] + arr[j]);
            minSum = Math.min(minSum, sum);
        }
        return minSum;
    }

    public static void main(String[] args) {
        MinSubArraySumSizeK obj = new MinSubArraySumSizeK();
        int[] arr = {7,5,3,8,2,-1,10,4,7};
        int k = 4;
        System.out.println(obj.solve(arr, k));
    }
}
