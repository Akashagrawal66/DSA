package recursionAndBacktracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given an integer A pairs of parentheses, write a function to generate all combinations
of well-formed parentheses of length 2*A.
*/
public class GenerateAllParanthesis {

    public ArrayList<String> generateParenthesis(int A) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('(', A);
        map.put(')', A);
        List<Character> list = new ArrayList<>();
        list.add('(');
        list.add(')');
        ArrayList<String> result = new ArrayList<>();
        dfs(A, new StringBuilder(), result, list, map);
        return result;
    }

    private void dfs(int A, StringBuilder str, ArrayList<String> strings, List<Character> list, Map<Character, Integer> map) {
        if (str.length() == 2 * A) {
            strings.add(str.toString());
            return;
        }
        for (int i = 0; i < 2; i++) {
            char ch = list.get(i);
            int num = map.get(ch);
            if (num > 0 && map.get('(') <= map.get(')')) {
                str.append(ch);
                map.put(ch, map.getOrDefault(ch, 0) - 1);
                dfs(A, str, strings, list, map);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                str.deleteCharAt(str.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        GenerateAllParanthesis obj = new GenerateAllParanthesis();
        System.out.println(obj.generateParenthesis(3));
    }
}
