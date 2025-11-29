package recursionAndBacktracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/*
Given an array of size N of candidate numbers A and a target number B.
Return all unique combinations in A where the candidate numbers sums to B.
Each number in A may only be used once in the combination.
Note:

All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, …, ak) must be in non-descending order. (i.e., a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
Input 1:                       Input 2:
 A = [10, 1, 2, 7, 6, 1, 5]     A = [2, 1, 3]
 B = 8                          B = 3
Output 1:                      Output 2:
 [                              [
  [1, 1, 6 ],                    [1, 2 ],
  [1, 2, 5 ],                    [3 ]
  [1, 7 ],                      ]
  [2, 6 ]
 ]
 1,1,2,5,6,7,10
 */
public class CombinationSum2 {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        dfs(A, B, 0, result, new ArrayList<>(), new boolean[A.size()],0);
        return result;
    }

    private void dfs(ArrayList<Integer> A, int B, int index, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> currArr, boolean[] visited, int sum) {
        if(sum == B) {
            result.add(new ArrayList<>(currArr));
            return;
        }
        if(index == A.size() || sum > B) {
            return;
        }
        for (int i=index;i<A.size();i++) {
            if(i != 0 && !visited[i-1] && Objects.equals(A.get(i - 1), A.get(i))) {
                continue;
            }
            currArr.add(A.get(i));
            visited[i] = true;
            dfs(A, B, i+1, result, currArr, visited, (sum+A.get(i)));
            currArr.remove(currArr.size()-1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        CombinationSum2 obj = new CombinationSum2();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(10);
        A.add(1);
        A.add(2);
        A.add(7);
        A.add(6);
        A.add(1);
        A.add(5);
        System.out.println(obj.combinationSum(A, 8));
    }
}
