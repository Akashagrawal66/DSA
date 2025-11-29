package recursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    ArrayList<ArrayList<String>> result = new ArrayList<>();
    public ArrayList<ArrayList<String>> solveNQueens(int n) {
        int len = 2*n-1;
        boolean[] clock = new boolean[len];
        boolean[] antiClock = new boolean[len];
        boolean[] column = new boolean[n];
        boolean[][] list = new boolean[n][n];
        recursion(clock, antiClock, column,list, 0, n);
        return result;
    }

    private void recursion(boolean[] clock, boolean[] antiClock, boolean[] column, boolean[][] list, int row, int n) {
        if (row == n) {
            addToResult(list);
            return;
        }
        for (int j=0;j<n;j++) {
            if(column[j] || (clock[row+j]) || antiClock[row-j+n-1]) {
                continue;
            }
            list[row][j] = true;
            column[j] = true;
            clock[row+j] = true;
            antiClock[row-j+n-1] = true;
            recursion(clock, antiClock, column, list, row+1, n);
            list[row][j] = false;
            column[j] = false;
            clock[row+j] = false;
            antiClock[row-j+n-1] = false;
        }
    }

    private void addToResult(boolean[][] list) {
        ArrayList<String> list1 = new ArrayList<>();
        for (boolean[] booleans : list) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < list.length; j++) {
                if (booleans[j]) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            list1.add(sb.toString());
        }
        result.add(list1);
    }

    public static void main(String[] args) {
        NQueens obj = new NQueens();
        var list = obj.solveNQueens(4);
        for (var li : list){
            System.out.println(li);
            System.out.println("---------------");
        }
    }
}
