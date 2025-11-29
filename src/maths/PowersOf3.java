package maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowersOf3 {
    public int[] solve(int A) {
        List<Integer> list = new ArrayList<>();
        while (A > 0) {
            double val = Math.log(A) / Math.log(3);
            int num = (int) Math.pow(3, Math.ceil(val));
            if (num > A) {
                num = (int) Math.pow(3, (int) val);
            }
            list.add(num);
            A -= num;
        }
        int[] ans = new int[list.size()];
        for (int i = 0, j = list.size() - 1; i < list.size(); i++, j--) {
            ans[i] = list.get(j);
        }
        return ans;
    }

    public int[] solve2(int A) {
        List<Integer> list = new ArrayList<>();
        int pow = 1;
        while (A> 0){
            int num = A%3;
            while (num > 0) {
                list.add(pow);
                num--;
            }
            A /= 3;
            pow *= 3;
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        PowersOf3 obj = new PowersOf3();
        System.out.println(Arrays.toString(obj.solve(1000431)));
        System.out.println(Arrays.toString(obj.solve2(1000431)));
    }
}
