package sorting;

import java.util.ArrayList;
import java.util.Collections;

public class MaxAndMinMagic {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int min = 0;
        int max = 0;
        int n = A.size();
        int mod = (int) (1e9+7);
        for(int i=0;i<n/2;i++) {
            max = (max + Math.abs(A.get(n-1-i) - A.get(i)))%mod;
        }
        for(int i=0;i<n;i+=2) {
            min = (min + (int)(Math.abs((long)A.get(i+1)-A.get(i))%mod))%mod;
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(max);
        list.add(min);
        return list;
    }

    public static void main(String[] args) {

    }
}
