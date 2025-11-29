package strings;

/*
You are given a string A of size N.
Return the string A after reversing the string word by word.
NOTE:

A sequence of non-space characters constitutes a word.
Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
If there are multiple spaces between words, reduce them to a single space in the reversed string.

Input 1:
A = "the sky is blue"
Input 2:
A = "this is ib"
Output 1:
"blue is sky the"
Output 2:
"ib is this"
*/
public class ReverseTheString {
    public String solve(String A) {
        A = A.trim();
        String[] arr = A.split(" ");
        if(arr.length == 1){
            return A;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=arr.length-1;i>0;i--){
            sb.append(arr[i]).append(" ");
        }
        sb.append(arr[0]);
        return sb.toString();
    }
}
