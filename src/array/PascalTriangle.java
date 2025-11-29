package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    public int[] getRow(int A) {
        int[] result = new int[A + 1];
        result[0] = 1;
        for (int i = 1; i <= A; i++) {
            int prev = 1;
            for (int j = 1; j <= A; j++) {
                int temp = result[j];
                result[j] = prev + result[j];
                prev = temp;
            }
            System.out.println(Arrays.toString(result));
        }
        return result;
    }

    public static void main(String[] args) {
        PascalTriangle obj = new PascalTriangle();
        System.out.println(Arrays.toString(obj.getRow(4)));
    }
}
