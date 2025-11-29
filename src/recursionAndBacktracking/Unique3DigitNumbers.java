package recursionAndBacktracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Unique3DigitNumbers {

    public int totalNumbers(int[] digits) {
        Arrays.sort(digits);
        int start = 0;
        for(int i=0;i<digits.length;i++) {
            if(digits[i] != 0){
                break;
            } else {
                start++;
            }
        }
        return generate(digits, new boolean[digits.length], start, 0, new HashSet<>());
    }
    private int generate(int[] digits, boolean[] visited, int index, int num, Set<Integer> set) {
        if(num>=100 && num <= 999 && (num&1) ==0) {
            if(!set.contains(num)) {
                System.out.println(num);
                set.add(num);
                return 1;
            }
        } else if (num > 999) {
            return 0;
        }
        System.out.println(num);
        int count = 0;
        for(int i=index;i<digits.length;i++) {
            if(!visited[i]) {
                int temp = digits[i];
                visited[i] = true;
                count += generate(digits, visited, 0, (num*10+temp), set);
                visited[i] = false;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Unique3DigitNumbers obj = new Unique3DigitNumbers();
        int[] A = {1,2,3,4};
        System.out.println(obj.totalNumbers(A));
    }
}
