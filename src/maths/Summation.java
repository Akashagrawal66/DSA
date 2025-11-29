package maths;

/*
* Given an integer A.
Calculate the sum = (ACr) * (r) * (r - 1) * (2r-2) for all r from 0 to A.
Return sum % 109 + 7.
* */
public class Summation {

    public int solve(int A) {
        int mod = (int) (1e9+7);
        int result = (int)(((long)A*(A-1))%mod);
        if(A == 2) {
            return result;
        }
        int base = 3;
        int power = A-2;
        int var = 1;
        while (power > 1) {
            if((power&1) == 1) {
                power -= 1;
                var = (int)(((long)var*base)%mod);
            }
            power /= 2;
            base = (int)(((long)base*base)%mod);
        }
        base = (int)(((long)base*var)%mod);
        return (int)(((long)result*base)%mod);
    }

    public static void main(String[] args) {
        Summation obj = new Summation();
        System.out.println(obj.solve(4));
    }
}
