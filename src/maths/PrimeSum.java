package maths;

import java.util.Arrays;

/*
* Given an even number A (greater than 2), return two prime numbers whose sum will be equal to the given number.
If there is more than one solution possible, return the lexicographically smaller solution.
* If [a, b] is one solution with a <= b, and [c,d] is another solution with c <= d, then
[a, b] < [c, d], If a < c OR a==c AND b < d.
NOTE: A solution will always exist. Read Goldbach's conjecture.
* */
public class PrimeSum {
    public int[] primesum(int A) {
        int[] result = new int[2];
        for(int i=2;i<=A/2;i++) {
            if(isPrime(i) && isPrime(A-i)) {
                result[0] = i;
                result[1] = A-i;
                return result;
            }
        }
        return result;
    }

    private boolean isPrime(int num) {
        for (int i=2;i*i<=num;i++) {
            if((num%i) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PrimeSum obj = new PrimeSum();
        System.out.println(Arrays.toString(obj.primesum(4)));
    }
}
