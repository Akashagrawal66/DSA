package recursionAndBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubsetInAscendingOrder {
    int k = 0;
    public int[][] subsets(int[] A) {
        Arrays.sort(A);
        int totalSubsets = 1<<A.length;
        int[][] result = new int[totalSubsets][A.length];
        generate(A, new ArrayList<>(), result, 0);
        return result;
    }

    private void generate(int[] A, List<Integer> curr,int[][] result,  int index) {
        result[k++] = toArray(curr);
        if (index == A.length) {
            return;
        }
        for (int i=index;i<A.length;i++) {
            curr.add(A[i]);
            generate(A, curr, result, i+1);
            curr.remove(curr.size()-1);
        }
    }

    private int[] toArray(List<Integer> curr) {
        int[] res = new int[curr.size()];
        for (int i=0;i<curr.size();i++) {
            res[i] = curr.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        AllSubsetInAscendingOrder obj = new AllSubsetInAscendingOrder();
        int[] A = {1,2,3};
        int[][] resul = obj.subsets(A);
        for (int[] i: resul) {
            System.out.println(Arrays.toString(i));
        }
    }
}
