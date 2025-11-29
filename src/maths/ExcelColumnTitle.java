package maths;

/*
* Given a positive integer A, return its corresponding column title as it appears in an Excel sheet.
* Ex:
    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
*
* */
public class ExcelColumnTitle {
    public String convertToTitle(int A) {
        StringBuilder sb = new StringBuilder();
        while (A > 0) {
            int temp = A % 26;
            char ch = temp == 0 ? 'Z' : (char) ('A' + (temp - 1));
            sb.append(ch);
            A = (A - 1) / 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        ExcelColumnTitle obj = new ExcelColumnTitle();
        System.out.println(obj.convertToTitle(32));
    }
}
