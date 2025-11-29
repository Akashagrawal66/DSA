package recursionAndBacktracking;

import java.util.ArrayList;

/*
Given two integers A and B, return all possible combinations of B numbers out of 1 2 3 ... A.
Make sure the combinations are sorted.
To elaborate,
Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
Entries should be sorted within themselves.
WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
*/
public class Combinations {
    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        combinations(A, B, 1, result, new ArrayList<>());
        return result;
    }

    private void combinations(int A, int B, int index, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> curr) {
        if(curr.size() == B) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i=index;i<=A;i++) {
            curr.add(i);
            combinations(A, B, i+1, result, curr);
            curr.remove(curr.size()-1);
        }
    }

    public static void main(String[] args) {
        Combinations obj = new Combinations();
        System.out.println(obj.combine(5, 3));
    }
}
