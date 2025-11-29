package maths;

public class PowerMod {
    public int power(int A, int B) {
        int mod = (int) (1e9 + 7);
        int ans = A;
        int var = 1;
        while (B > 1) {
            if ((B & 1) != 0) {
                B = B-1;
                var = (int) ((long) var * ans)%mod;
            }
            ans = (int) (((long) ans * ans)%mod);
            B = B/2;
        }
        ans = (int) (((long) ans * var)%mod);
        return ans;
    }

    public int powerRecursive(int A, int B, int mod) {
        if(B == 0)
            return 1;
        if((B&1) == 0) {
            return powerRecursive((int) (((long) A * A)%mod), B/2, mod);
        }
        return (int)((long) A * powerRecursive((int) (((long) A * A) % mod), (B - 1) / 2, mod));
    }

    public static void main(String[] args) {
        PowerMod powerMod = new PowerMod();
        System.out.println(powerMod.power(3, 6));
        System.out.println(powerMod.powerRecursive(3, 6, (int) (1e9+7)));
    }
}
