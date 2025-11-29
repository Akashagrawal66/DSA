package array;

import java.util.ArrayList;
import java.util.List;

public class GenerateSubsets {
    private List<List<Integer>> generate(int[] arr) {
        int n = arr.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, n); i++) {
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<n;j++) {
                if((i&(1<<j)) > 0) {
                    list.add(arr[j]);
                }
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        GenerateSubsets obj = new GenerateSubsets();
        int[] arr = {2,3,4,5};
        System.out.println(obj.generate(arr));
    }
}
