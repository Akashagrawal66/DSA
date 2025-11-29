package searching;

public class FirstOccurrenceGreaterThanK {
    public int solve(int[] arr, int k) {
        int start = 0;
        int end = arr.length;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] <= k) {
                start = mid+1;
            } else if (arr[mid] > k) {
                end = mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        FirstOccurrenceGreaterThanK obj = new FirstOccurrenceGreaterThanK();
        int[] arr = {1,2,2,3,4,4,5,6,8};
        System.out.println(obj.solve(arr, 8));
    }
}
