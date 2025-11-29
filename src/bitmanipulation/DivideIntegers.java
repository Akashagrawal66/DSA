package bitmanipulation;

/*
Divide two integers without using multiplication, division and mod operator.
Return the floor of the result of the division.
Also, consider if there can be overflow cases i.e output is greater than INT_MAX, return INT_MAX.
NOTE: INT_MAX = 2^31 - 1
*/
public class DivideIntegers {
    public int divide(int A, int B) {
        if (A == Integer.MIN_VALUE && B == -1) {
            return Integer.MAX_VALUE;
        }
        long a = Math.abs((long) A);
        long b = Math.abs((long) B);
        int result = 0;
        while (a >= b) {
            long temp = b;
            long multiple = 1;
            while (a >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            a -= temp;
            result += (int) multiple;
        }
        return (A >= 0) & (B >= 0) ? result : -result;
    }

    public static void main(String[] args) {
        DivideIntegers obj = new DivideIntegers();
        System.out.println(obj.divide(-2147483648, 1));
    }
}
