package hashing;

import java.util.ArrayList;
import java.util.List;

/*
Given an array A of N strings, return all groups of strings that are anagrams.
Represent a group by a list of integers representing the index(1-based) in the original list. Look at the sample case for clarification.
NOTE: Anagram is a word, phrase, or name formed by rearranging the letters, such as 'spar', formed from 'rasp'.

Input 1:
 A = [cat, dog, god, tca]
Input 2:
 A = [rat, tar, art]
Output 1:
 [ [1, 4],
   [2, 3] ]
Output 2:
 [ [1, 2, 3] ]
*/
public class Anagrams {
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        int n = A.size();
        List<Boolean> checks = new ArrayList<>();
        for(int i=0;i<n;i++){
            checks.add(false);
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!checks.get(i)){
                int[] arr = new int[26];
                ArrayList<Integer> temp = new ArrayList<>();
                frequencyArray(arr, A.get(i));
                temp.add(i+1);
                checks.set(i , true);
                for(int j=i+1;j<n;j++){
                    if(!checks.get(j)){
                        int[] arr1 = new int[26];
                        frequencyArray(arr1, A.get(j));
                        if(checkIfEqual(arr, arr1)){
                            checks.set(j , true);
                            temp.add(j+1);
                        }
                    }
                }
                result.add(temp);
            }
        }
        return result;
    }
    public void frequencyArray(int[] arr, String str){
        for(int i=0;i<str.length();i++){
            arr[str.charAt(i) - 'a']++;
        }
    }
    public boolean checkIfEqual(int[] arr1, int[] arr2){
        for(int i=0;i<arr1.length;i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
}
