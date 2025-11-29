package maths;

/*
* Given three integers A, B and C,
* where A represents n, B represents r and C represents p and
* p is a prime number greater than equal to n, find and
* return the value of nCr%p where nCr % p = (n!/((n-r)!*r!))%p.
x! means factorial of x i.e x! = 1 * 2 * 3... * x.
NOTE: For this problem, we are considering 1 as prime.
* */
public class ComputenCrmodPrime {
    public int solve(int A, int B, int C) {
        if (B > A - B) {
            B = A - B;
        }
        int factN = 1;
        int temp = A;
        for (int i = B; i > 0; i--) {
            factN = (int) (((long) factN * temp) % C);
            temp--;
        }
        return (int) (((long) factN * power(fact(B, C), C - 2, C)) % C);
    }

    private int fact(int n, int mod) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return (int) (((long) n * fact(n - 1, mod)) % mod);
    }

    private int power(int A, int B, int mod) {
        int var = 1;
        while (B > 1) {
            if ((B & 1) == 1) {
                B -= 1;
                var = (int) (((long) var * A) % mod);
            }
            B /= 2;
            A = (int) (((long) A * A) % mod);
        }
        return (int) (((long) A * var) % mod);
    }

    public static void main(String[] args) {
        ComputenCrmodPrime obj = new ComputenCrmodPrime();
        System.out.println(obj.solve(5, 2, 13));
    }
}
