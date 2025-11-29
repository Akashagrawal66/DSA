package sorting;

import java.util.ArrayList;
import java.util.List;

/*
Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j) is called an inversion of A.
Find the total number of inversions of A modulo (109 + 7).
*/
public class InversionCountArray {
    int count = 0;
    int mod = (int) (1e9 + 7);

    public int solve(ArrayList<Integer> A) {
        dfs(A, 0, A.size() - 1);
        return count;
    }

    private List<Integer> dfs(ArrayList<Integer> A, int start, int end) {
        if (start == end) {
            return List.of(A.get(start));
        }
        int mid = start + (end - start) / 2;
        List<Integer> list1 = dfs(A, start, mid);
        List<Integer> list2 = dfs(A, mid + 1, end);
        return mergeTwoLists(list1, list2);
    }

    private List<Integer> mergeTwoLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            int num1 = list1.get(i);
            int num2 = list2.get(j);
            if (num1 > num2) {
                list.add(num2);
                count = (count + (list1.size() - i)) % mod;
                j++;
            } else {
                list.add(num1);
                i++;
            }
        }
        while (i < list1.size()) {
            list.add(list1.get(i++));
        }
        while (j < list2.size()) {
            list.add(list2.get(j++));
        }
        return list;
    }

    public static void main(String[] args) {
        InversionCountArray obj = new InversionCountArray();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(45);
        A.add(20);
        A.add(15);
        A.add(25);
        A.add(46);
        A.add(50);
        System.out.println(obj.solve(A));
    }
}
