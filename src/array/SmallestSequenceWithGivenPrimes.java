package array;

import tree.heap.MaxHeap;

import java.util.*;

public class SmallestSequenceWithGivenPrimes {
    public int[] solve(int A, int B, int C, int D) {
        List<Integer> list = new ArrayList<>();
        int count = 0;
        Set<Integer> set = new HashSet<>();
        list.add(1);
        while (count < D) {
            int p = -1, q = -1, r = -1;
            int cnt = 0;
            for (int num : list) {
                if (p == -1 && !set.contains(num * A)) {
                    p = num * A;
                    cnt++;
                }
                if (q == -1 && !set.contains(num * B)) {
                    q = num * B;
                    cnt++;
                }
                if (r == -1 && !set.contains(num * C)) {
                    r = num * C;
                    cnt++;
                }
                if (cnt == 3) {
                    System.out.println(p + " " + q + " " + r);
                    System.out.println("Set: " + set);
                    break;
                }
                System.out.println("After Loop: " + p + " " + q + " " + r);
                System.out.println("Set: " + set);
            }
            System.out.println("-------------------------");
            int min = Math.min(p, Math.min(q, r));
            list.add(min);
            set.add(min);
            count++;
        }
        list.remove(0);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        SmallestSequenceWithGivenPrimes obj = new SmallestSequenceWithGivenPrimes();
        System.out.println(Arrays.toString(obj.solve(2, 3, 5, 6)));
    }
}
