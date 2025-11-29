package bitmanipulation;

/*
Given an integer A.
Two numbers, X and Y, are defined as follows:

X is the greatest number smaller than A such that the XOR sum of X and A is the same as the sum of X and A.
Y is the smallest number greater than A, such that the XOR sum of Y and A is the same as the sum of Y and A.
Find and return the XOR of X and Y.

NOTE 1: XOR of X and Y is defined as X ^ Y where '^' is the BITWISE XOR operator.

NOTE 2: Your code will be run against a maximum of 100,000 Test Cases.
*/
public class StrangeEquality {
    public int solve(int A) {
        int X = 0;
        int Y = 0;
        for (int i = 0;i<32;i++) {
            int num = (1<<i);
            int temp = (A&num);
            if(temp == 0 && num < A) {
                X += num;
            } else if (num > A) {
                Y = num;
                break;
            }
        }
        return X^Y;
    }

    public static void main(String[] args) {
        StrangeEquality obj = new StrangeEquality();
        System.out.println(obj.solve(11));
    }
}
