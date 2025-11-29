package array;

import java.util.HashSet;
import java.util.Set;

public class PairWithGivenXOR {
    public static void main(String[] args) {
        int[] arr = {5, 4, 10, 15, 7, 6};
        int b = 5;
        System.out.println(PairWithGivenXOR.solve(arr, b));
    }
    public static int solve(int[] A, int B) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        int n = A.length;
        for(int i: A) {
            set.add(i);
        }
        for(int i: A){
            if(set.contains(B^i)) {
                count++;
                set.remove(i);
            }
        }
        return count;
    }
}
