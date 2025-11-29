package array;

import java.util.Stack;

public class SimplifyDirectoryPath {
    public String stt;

    public String getStt() {
        return stt;
    }

    public void setStt(String stt) {
        this.stt = stt;
    }

    public String simplifyPath(String A) {
        int i = A.length() - 1;
        int count = 0;
        StringBuilder ans = new StringBuilder();
        while (i >= 0) {
            char ch = A.charAt(i);
            StringBuilder sb = new StringBuilder();
            if (ch == '/') {
                i--;
                continue;
            }
            while (i >= 0 && A.charAt(i) != '/') {
                ch = A.charAt(i--);
                sb.append(ch);
            }
            String str = sb.toString();
            if (str.equals("..")) {
                count++;
            } else if (str.matches("^[a-z]+$") && count > 0) {
                count--;
            } else if (str.matches("^[a-z]+$") && count == 0) {
                ans.append(str).append("/");
            }
        }
        if(ans.isEmpty()) {
            ans.append("/");
        }
        String str = "";
        String[] split = str.split("--");
        setStt(split[0]);
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        SimplifyDirectoryPath obj = new SimplifyDirectoryPath();
        String A = "/../";
        System.out.println(obj.simplifyPath(A));
    }
}
