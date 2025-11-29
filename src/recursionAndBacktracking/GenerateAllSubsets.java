package recursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllSubsets {
    public void solve(int[] A) {
        recursion(A, 0, new ArrayList<>());
    }
    private void recursion(int[] A, int index, List<Integer> curr) {
        if(index == A.length) {
            System.out.println(curr);
            return;
        }
        recursion(A, index+1, curr);
        curr.add(A[index]);
        recursion(A, index+1, curr);
        curr.remove(curr.size()-1);
    }

    public static void main(String[] args) {
        GenerateAllSubsets obj = new GenerateAllSubsets();
        int[] A = {1,2,3};
        obj.solve(A);
    }
}
