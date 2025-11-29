package array;

public class ConstructTheArray {

    public static int[] constructArray(int A, int B, int C) {
        int[] array = new int[A];
        int minLast = Integer.MAX_VALUE;
        int start = Integer.MAX_VALUE;
        int diff = -1;
        for (int i = 1; i <= A; i++) {
            for (int j = i + 1; j <= A; j++) {
                if ((C - B) % (j - i) == 0) {
                    int d = (C - B) / (j - i);
                    int a = B - (i - 1) * d;
                    int last = a + (A - 1) * d;
                    if (a > 0 && last < minLast) {
                        minLast = last;
                        start = a;
                        diff = d;
                    } else if (a > 0 && last == minLast && a < start) {
                        start = a;
                        diff = d;
                    }
                }
            }
        }
        for (int i = 1; i <= A; i++) {
            array[i - 1] = start + (i - 1) * diff;
        }
        return array;
    }

    public static void main(String[] args) {
        int A = 2;
        int B = 2;
        int C = 10;

        int[] result = constructArray(A, B, C);
        for (int value : result) {
            System.out.print(value + " ");
        }
    }

}
