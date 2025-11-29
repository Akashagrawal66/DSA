package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FirstSubArrayAddsToValue {

    private String nn;

    private void setString(String n){
        this.nn = n;
    }

    public int solve(int[] A, int B) {
        int i = 0;
        int j = -1;

        var ss = Optional.of(null);
        System.out.println(ss);
        return 1;
    }

    private int sum(int A) {
        if(A == 0){
            return 0;
        }
        return A%10 + sum(A/10);
    }

    public static void main(String[] args) {
        List<String> ss = new ArrayList<>();
        var dd = ss.stream()
                .filter(str -> str.charAt('A') == 0)
                .reduce((first, second) -> second);
        if (dd.isEmpty()) {
            System.out.println("empty");
        } else {
            System.out.println(dd.get());
        }

    }
}
