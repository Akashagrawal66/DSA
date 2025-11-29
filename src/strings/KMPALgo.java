package strings;

import java.util.ArrayList;
import java.util.List;

public class KMPALgo {
    private List<Integer> computeLPSArray(String pattern) {
        int len = 0, i = 1;
        int n = pattern.length();
        List<Integer> lps = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            lps.add(0);
        }
        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps.set(i, len);
                i++;
            } else {
                if (len == 0) {
                    lps.set(i, 0);
                    i++;
                } else {
                    len = lps.get(len - 1);
                }
            }
        }
        return lps;
    }

    public List<Integer> search(String pat, String txt) {
        List<Integer> result = new ArrayList<>();
        int n = txt.length();
        int m = pat.length();
        List<Integer> lps = computeLPSArray(pat);
        int i = 0, j=0;
        while (i < n) {
            if (txt.charAt(i) == txt.charAt(j)) {
                i++;
                j++;
                if (j == m) {
                    result.add(i - j);
                    j = lps.get(j-1);
                }
            } else {
                if (j != 0) {
                    j = lps.get(j-1);
                } else {
                    i++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        KMPALgo obj = new KMPALgo();
        String txt = "aabaacaadaabaaba";
        String pat = "aaba";
        System.out.println(obj.search(pat, txt));
    }
}
