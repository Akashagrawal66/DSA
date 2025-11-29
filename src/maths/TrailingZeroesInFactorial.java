package maths;

public class TrailingZeroesInFactorial {
    public int trailingZeroes(int A) {
        int ans = 0;
        int i = 5;
        while( i<=A) {
            ans += (A/i);
            i = i*5;
        }
        return ans;
    }
    public static void main(String[] args) {
        TrailingZeroesInFactorial obj = new TrailingZeroesInFactorial();
        System.out.println(obj.trailingZeroes(9247));
    }
}
