package twopointers;

import sorting.UniqueElements;

import java.util.ArrayList;
import java.util.Collections;

/*
Given two arrays of integers A and B, Sort A in such a way that the relative order among the elements will be the same as those are in B.
For the elements not present in B, append them at last in sorted order.
Return the array A after sorting from the above method.
NOTE: Elements of B are unique.
Input 1:
A = [1, 2, 3, 4, 5, 4]
B = [5, 4, 2]
Input 2:
A = [5, 17, 100, 11]
B = [1, 100]
Output 1:
[5, 4, 4, 2, 1, 3]
Output 2:
[100, 5, 11, 17]
*/
public class SortArrayInGIvenOrder {

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        A.sort((a1, a2) -> {
            int index1 = B.indexOf(a1);
            int index2 = B.indexOf(a2);
            if (index1 == -1 && index2 == -1) {
                return a1 - a2;
            } else if (index1 == -1) {
                return 1;
            } else if (index2 == -1) {
                return -1;
            }
            return index1 - index2;
        });
        return A;
    }

    public static void main(String[] args) {
        SortArrayInGIvenOrder obj = new SortArrayInGIvenOrder();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        UniqueElements obj2 = new UniqueElements();
        int[] arr1 = {1, 2, 3, 4, 5,5, 4};
        int[] arr2 = {5,2};

        obj2.addToList(list1, arr1);
        obj2.addToList(list2, arr2);
        System.out.println(obj.solve(list1, list2));
    }
}
