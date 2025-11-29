package recursionAndBacktracking;

/*
Given an array of integers A of size N and an integer B.
Return number of non-empty subsequences of A of size B having a sum <= 1000.
*/
public class Sixlets {
    int result = 0;

    public int solve(int[] A, int B) {
        recursion(A, B, 0, 0, 0);
        return result;
    }

    private void recursion(int[] A, int B, int sum, int index, int size) {
        if (index == A.length) {
            if (size == B && sum <= 1000) {
                result++;
            }
            return;
        } else if (size == B && sum <= 1000) {
            result++;
            return;
        }
        recursion(A, B, sum, index + 1, size);
        sum += A[index];
        recursion(A, B, sum, index + 1, size + 1);
    }

    public static void main(String[] args) {
        Sixlets obj = new Sixlets();
        int[] A = {1, 2, 8};
        int B = 2;
        System.out.println(obj.solve(A, B));
    }
}
