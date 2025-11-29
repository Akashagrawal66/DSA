package maths;

/*
* A lucky number is a number that has exactly 2 distinct prime divisors.
You are given a number A, and you need to determine the count of lucky numbers between the range 1 to A (both inclusive).
* 1 <= A <= 50000
Input 1:
 A = 8
Output 1:
1
* */
public class LuckyNumbers {

    public int solve(int A) {
        int[] arr = new int[A + 1];
        for (int i = 2; i <= A; i++) {
            if (arr[i] == 0) {
                for (int j = i * 2; j <= A; j += i) {
                    arr[j]++;
                }
            }
        }
        int count = 0;
        for (int i : arr) {
            if (i == 2) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LuckyNumbers obj = new LuckyNumbers();
        System.out.println(obj.solve(12));
    }
}
