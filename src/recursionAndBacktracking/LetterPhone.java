package recursionAndBacktracking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given a digit string A, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below.
Digit 0 maps to 0 itself. Digit 1 maps to 1 itself.
NOTE: Make sure the returned strings are lexicographically sorted.
*/
public class LetterPhone {
    int k = 0;

    public String[] letterCombinations(String A) {
        String[] numMapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        String[] result = new String[(1<<8)];
        recursion(A, 0, new StringBuilder(), result, numMapping);
        return Arrays.stream(result).limit(k).toList().toArray(new String[0]);
    }

    private void recursion(String A, int index, StringBuilder sb, String[] result, String[] mapping) {
        if (index == A.length()) {
            if (sb.length() == 3)
                result[k++] = sb.toString();
            return;
        }
        for (int i = index; i < A.length(); i++) {
            String map = mapping[A.charAt(i) - '0'];
            for (int j = 0; j < map.length(); j++) {
                sb.append(map.charAt(j));
                recursion(A, i+1, sb, result, mapping);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        LetterPhone obj = new LetterPhone();
        System.out.println(Arrays.toString(obj.letterCombinations("234")));

    }
}
