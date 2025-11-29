package bitmanipulation;

/*
* We define f(X, Y) as the number of different corresponding bits in the binary representation of X and Y.
For example, f(2, 7) = 2, since the binary representation of 2 and 7 are 010 and 111, respectively.
* The first and the third bit differ, so f(2, 7) = 2.

You are given an array of N positive integers, A1, A2,..., AN. Find sum of f(Ai, Aj) for all pairs (i, j)
* such that 1 ≤ i, j ≤ N. Return the answer modulo 109+7.
* */
public class DifferentBitsSumOtherwise {
    public int cntBits(int[] A) {
        int n = A.length;
        int count= 0;
        int mod = (int) (1e9+7);
        for (int i=0;i<32;i++) {
            int sum = 0;
            for (int k : A) {
                sum = (sum + ((k >> i) & 1)) % mod;
            }
            if(sum > 0)
                count = (int)((count + (((long)(n-sum))*2*sum))%mod);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {81,13,2,7,96}; //72
        DifferentBitsSumOtherwise obj = new DifferentBitsSumOtherwise();
        System.out.println(obj.cntBits(A));
    }
}
