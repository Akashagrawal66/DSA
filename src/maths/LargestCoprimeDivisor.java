package maths;

//X divides A i.e. A % X = 0
//X and B are co-prime i.e. gcd(X, B) = 1
public class LargestCoprimeDivisor {
    public int cpFact(int A, int B) {
        while (gcd(A,B) != 1) {
            A = A/gcd(A, B);
        }
        return A;
    }

    private int gcd(int a, int b) {
        if(a == 0) {
            return b;
        }
        return gcd(b%a, a);
    }

    public static void main(String[] args) {
        LargestCoprimeDivisor obj = new LargestCoprimeDivisor();
        System.out.println(obj.cpFact(15, 0));
        String dd = "12";
        System.out.println(Integer.valueOf(dd));
    }
}
