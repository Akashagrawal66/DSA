package recursionAndBacktracking;

import java.util.*;

public class UniqueSubsets {
    public List<List<Integer>> solve(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>(map.keySet());
        subsets(map, list, result, 0, new int[list.size()]);
        return result;
    }

    private void subsets(Map<Integer, Integer> map, List<Integer> list, List<List<Integer>> result, int index, int[] frequencyArray) {
        if (index == list.size()) {
            formArray(frequencyArray, list, result);
            return;
        }
        int freq = map.get(list.get(index));
        for (int j = 0; j <= freq; j++) {
            frequencyArray[index] = j;
            subsets(map, list, result, index + 1, frequencyArray);
        }
    }

    private void formArray(int[] frequencyArray, List<Integer> list, List<List<Integer>> result) {
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            int freq = frequencyArray[i];
            for (int j = 1; j <= freq; j++) {
                list1.add(num);
            }
        }
        result.add(list1);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // To check for duplicacy
        getSubsets(nums, result, new ArrayList<>(), 0);
        return result;
    }

    public void getSubsets(int[] nums, List<List<Integer>> result, List<Integer> temp, int ind){
        result.add(new ArrayList<>(temp));
        for(int i = ind; i < nums.length; i++){
            if(i > ind && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            getSubsets(nums, result, temp, i + 1);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        UniqueSubsets obj = new UniqueSubsets();
        int[] A = {1, 1, 2, 2};
        System.out.println(obj.solve(A));
        System.out.println(obj.subsetsWithDup(A));
    }
}
