package recursionAndBacktracking;

import java.util.ArrayList;

/*
Given a string A, partition A such that every string of the partition is a palindrome.
Return all possible palindrome partitioning of A.
Ordering the results in the answer : Entry i will come before Entry j if :

len(Entryi[0]) < len(Entryj[0]) OR
(len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR * * *
(len(Entryi[0]) == len(Entryj[0]) AND ... len(Entryi[k] < len(Entryj[k]))
*/
public class PalindromePartitioning {
    public ArrayList<ArrayList<String>> partition(String a) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        recursion(result, 0, new ArrayList<>(), a);
        return result;
    }

    private void recursion(ArrayList<ArrayList<String>> result, int index, ArrayList<String> objects, String a) {
        if(index == a.length()) {
            result.add(new ArrayList<>(objects));
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=index;i<a.length();i++) {
            char ch = a.charAt(i);
            sb.append(ch);
            if (isPalindrome(sb.toString())) {
                objects.add(sb.toString());
                recursion(result, i+1, objects, a);
                objects.remove(objects.size()-1);
            }
        }
    }

    private boolean isPalindrome(String string) {
        int n = string.length();
        for (int i=0;i<n/2;i++) {
            if(string.charAt(i) != string.charAt(n-i-1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning obj = new PalindromePartitioning();
        System.out.println(obj.partition("aab"));
    }
}
