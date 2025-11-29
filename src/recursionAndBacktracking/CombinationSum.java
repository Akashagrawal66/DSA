package recursionAndBacktracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Given an array of candidate numbers A and a target number B, find all unique combinations in A where the candidate numbers sums to B.
The same repeated number may be chosen from A unlimited number of times.
Note:
1) All numbers (including target) will be positive integers.
2) Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
3) The combinations themselves must be sorted in ascending order.
4) CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR ... (a1 = b1 AND a2 = b2 AND ... ai = bi AND ai+1 > bi+1)
5) The solution set must not contain duplicate combinations.
*/
public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Collections.sort(A);
        dfs(A, B, 0, 0, result, new ArrayList<>());
        return result;
    }

    private void dfs(ArrayList<Integer> a, int b, int index, int currSum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> curr) {
        if (currSum == b) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i = index; i < a.size(); i++) {
            int num = a.get(i);
            if ((i != 0 && num == a.get(i - 1)) || (currSum + num > b)) {
                continue;
            }
            curr.add(num);
            dfs(a, b, i, currSum + num, result, curr);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum obj = new CombinationSum();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(10);
        list.add(6);
        list.add(11);
        list.add(1);
        list.add(16);
        list.add(8);
        int B = 28;
        System.out.println(obj.combinationSum(list, B));
    }
}
