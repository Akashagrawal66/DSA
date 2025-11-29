package bitmanipulation;

/*
Given an array of integers, every element appears thrice except for one, which occurs once.
Find that element that does not appear thrice.
NOTE: Your algorithm should have a linear runtime complexity.
Could you implement it without using extra memory?
*/
public class SingleNumberII {
    public int singleNumber(final int[] A) {
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            int count = 0;
            for (int j : A) {
                if ((j & (1 << i)) > 0) {
                    count++;
                }
            }
            result += (count % 3);
            result <<= 1;
        }
        return result >> 1;
    }

    public static void main(String[] args) {
        SingleNumberII obj = new SingleNumberII();
        int[] A = {1, 2, 4, 3, 3, 2, 2, 3, 1, 1};
        System.out.println(obj.singleNumber(A));
    }
}
