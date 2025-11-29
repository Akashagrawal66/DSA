package array;

import java.util.Arrays;
import java.util.List;

public class N3RepeatNumber {
    public int repeatedNumber(final List<Integer> list) {
        int a = 0, b = 0;
        int countA = 0, countB = 0;
        for (int num : list) {
            if (a == num) {
                countA++;
            } else if (b == num) {
                countB++;
            } else if (countA == 0) {
                a = num;
                countA++;
            } else if (countB == 0) {
                b = num;
                countB++;
            } else {
                countA--;
                countB--;
            }
        }
        countA = 0;
        countB = 0;
        for (int i : list) {
            if (i == a) {
                countA++;
            } else if (i == b) {
                countB++;
            }
        }
        if (countA > list.size() / 3) {
            return a;
        } else if (countB > list.size() / 3) {
            return b;
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 1, 4, 1);
        N3RepeatNumber obj = new N3RepeatNumber();
        System.out.println(obj.repeatedNumber(list));
    }
}
