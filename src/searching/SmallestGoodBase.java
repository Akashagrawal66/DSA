package searching;

/*
Given an integer A, we call k >= 2 a good base of A, if all digits of A base k are 1. Now given a string representing A,
you should return the smallest good base of A in string format.Input 1:
    A = "13"
Output 1:
    "3"     (13 in base 3 is 111)
Input 2:
    A = "4681"
Output 2:
    "8" (4681 in base 8 is 11111).
    */
public class SmallestGoodBase {
    public String solve(String A) {
        long low = 2;
        long high = Long.parseLong(A);
        long result = low;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (check(A, mid)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return String.valueOf(result);
    }

    private boolean check(String a, long mid) {
        long num = Long.parseLong(a);
        System.out.println("Checking for base: " + mid);
        while (num > 0) {
            int rem = (int) (num % mid);
            System.out.println("Rem is: " + rem);
            if (rem > 1) {
                return false;
            }
            num /= mid;
        }
        return true;
    }

    public static void main(String[] args) {
        SmallestGoodBase obj = new SmallestGoodBase();
        System.out.println(obj.solve("4681"));
    }
}
