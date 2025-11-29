package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UniqueElements {

    public int solve(ArrayList<Integer> A) {
        int steps = 0;
        Collections.sort(A);
        for(int i=1;i<A.size();i++) {
            int num = A.get(i);
            if(num == A.get(i-1)) {
                A.set(i, num+1);
                steps++;
            } else if (num < A.get(i-1)) {
                int diff = A.get(i-1) - num;
                A.set(i, A.get(i-1)+1);
                steps += (diff+1);
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        UniqueElements obj = new UniqueElements();
        ArrayList<Integer> list = new ArrayList<>();
        int[] arr = {51,6,10,8,22,61,56,48,88,85,21,98,81,76,71,68,18,6,14,23,72,18,56,30,97,100,81,5,99,2,85,67,46,32,66,51,76,53,36,31,81,56,26,75,69,54,54,54,83,41,86,48,7,32,85,23,47,23,18,45,79,95,73,15,55,16,66,73,13,85,14,80,39,92,66,20,22,25,34,14,51,14,17,10,100,35,9,83,31,60,24,37,69,62};
        obj.addToList(list, arr);
        System.out.println(obj.solve(list));
    }
    public void addToList(ArrayList<Integer> list, int[] arr) {
        Arrays.stream(arr).forEach(list::add);
    }

    public void addToList(ArrayList<String> list, String[] arr) {
        list.addAll(Arrays.asList(arr));
    }
}
