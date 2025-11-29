package array;

public class MinMaxSubarray {
    public static void main(String[] args) {
        int[] arr = {4,4,4,4};
        MinMaxSubarray subarray = new MinMaxSubarray();
        System.out.println(subarray.solve(arr));
    }
    private int solve(int[] arr){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i: arr){
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        int minIndex = -1;
        int maxIndex = -1;
        int result = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++) {
            if(arr[i] == min) {
                minIndex = i;
            }
            if ( arr[i] == max) {
                maxIndex = i;
            }

            if(minIndex != -1 && maxIndex != -1){
                result = Math.min(result, Math.abs(minIndex-maxIndex)+1);
            }
        }
        return result;
    }
}
