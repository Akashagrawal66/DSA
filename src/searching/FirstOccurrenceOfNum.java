package searching;

public class FirstOccurrenceOfNum {

    public int solve(int[] arr, int k) {
        int start = 0;
        int end = arr.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < k) {
                start = mid + 1;
            } else if (arr[mid] > k) {
                end = mid - 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 10, 10, 10, 18, 20, 20, 20, 27};
        FirstOccurrenceOfNum obj = new FirstOccurrenceOfNum();
        System.out.println(obj.solve(arr, 2));
    }
}
