package recursionAndBacktracking;

import java.util.*;

/*
Given an array of integers A, the array is squareful if for every pair of adjacent elements,
their sum is a perfect square.

Find and return the number of permutations of A that are squareful.
Two permutations A1 and A2 differ if and only if there is some index i such that A1[i] != A2[i].
*/
public class NumberOfSquarefulArrays {

    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        return permutations(A, new boolean[A.size()], new ArrayList<>());
    }

    private int permutations(ArrayList<Integer> A, boolean[] visited, List<Integer> curr) {
        if (curr.size() == A.size()) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < A.size(); i++) {
            if (visited[i] || (i > 0 && Objects.equals(A.get(i - 1), A.get(i)) && !visited[i - 1]) || (!curr.isEmpty() && !checkIfPerfectSquare(curr.get(curr.size() - 1) + A.get(i)))) {
                continue;
            }
            visited[i] = true;
            curr.add(A.get(i));
            count += permutations(A, visited, curr);
            visited[i] = false;
            curr.remove(curr.size() - 1);
        }
        return count;
    }

    private boolean checkIfPerfectSquare(int num) {
        int a = (int) Math.sqrt(num);
        return a * a == num;
    }

    public static void main(String[] args) {
        NumberOfSquarefulArrays obj = new NumberOfSquarefulArrays();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(8);
        A.add(8);
        A.add(8);
        A.add(8);
        A.add(8);
        A.add(8);
        System.out.println(obj.solve(A));
    }
}
