package maths;

/*
* Given a positive integer A.
Return the number of ways it can be written as a sum of consecutive positive integers.*/
public class ConsecutiveNumbersSum {

    public int solve(int A) {
        int ans = 0;
        for (int i = 1;i*i<2*A;i++) {
            if((A-(i*(i-1)/2))%i == 0) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ConsecutiveNumbersSum obj = new ConsecutiveNumbersSum();
        System.out.println(obj.solve(15));
    }
}
