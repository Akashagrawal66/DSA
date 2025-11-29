package array;

public class SubArrayOr {
    public int solve(int[] A) {
        long num = 1L;
        long sum = 0L;
        int n = A.length;
        int mod = (int) 1e9 + 7;
        for (int i = 0; i < 32; i++) {
            int ind = n;
            for (int j = n - 1; j >= 0; j--) {
                if ((A[j] & num) == num) {
                    ind = j;
                }
                sum += (n - ind) * num;
                System.out.println(sum);
            }
            System.out.println("-------");
            num *= 2;
        }
        return (int) (sum % mod);
    }

    public static void main(String[] args) {
        SubArrayOr obj = new SubArrayOr();
        int[] A = {1, 2, 3, 4, 5};
        System.out.println(obj.solve(A));
    }
}
