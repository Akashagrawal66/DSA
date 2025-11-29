package maths;

/*
Given a column title as appears in an Excel sheet, return its corresponding column number.
1 <= length of the column title <= 5
Input 1:
 AB
Input 2:
 BB
Example Output
Output 1:
 28
Output 2:
 54
* */
public class ExcelColumnNumber {
    public int titleToNumber(String A) {
        int base = 1;
        int result = 0;
        for (int i=A.length()-1;i>=0;i--) {
            int num = A.charAt(i) - 'A' + 1;
            result += (base*num);
            base *= 26;
        }
        return result;
    }

    public static void main(String[] args) {
        ExcelColumnNumber obj = new ExcelColumnNumber();
        System.out.println(obj.titleToNumber("AB"));
    }
}
