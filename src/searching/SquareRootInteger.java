package searching;

/*
Given an integer A. Compute and return the square root of A.
If A is not a perfect square, return floor(sqrt(A)).

NOTE:
   The value of A*A can cross the range of Integer.
   Do not use the sqrt function from the standard library.
   Users are expected to solve this in O(log(A)) time.
   */
public class SquareRootInteger {
    public int sqrt(int A) {
        if (A <= 1) {
            return A;
        }
        int start = 1;
        int end = A / 2 + 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid < A / mid) {
                start = mid + 1;
            } else if (mid > A / mid) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return start <= A / start ? start : start - 1;
    }

    public static void main(String[] args) {
        SquareRootInteger obj = new SquareRootInteger();
        System.out.println(obj.sqrt(740819855));
        System.out.println(Integer.MAX_VALUE);
    }
}
