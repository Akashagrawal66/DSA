package bitmanipulation;

/*
You have an array A with N elements. We have two types of operation available on this array :
We can split an element B into two elements, C and D, such that B = C + D.
We can merge two elements, P and Q, to one element, R, such that R = P ^ Q i.e., XOR of P and Q.
You have to determine whether it is possible to convert array A to size 1,
containing a single element equal to 0 after several splits and/or merge?
*/
public class InterestingArray {
    public String solve(int[] A) {
        int count = 0;
        for (int i: A) {
            if ((i&1) > 0) {
                count++;
            }
        }
        if ((count&1) > 0) {
            return "No";
        }
        return "Yes";
    }

    public static void main(String[] args) {
        InterestingArray obj = new InterestingArray();
        int[] A = {1, 4, 6, 7, 8, 9};
        System.out.println(obj.solve(A));
    }
}
