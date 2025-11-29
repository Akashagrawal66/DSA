package array;

public class SmallestPositiveMissingInteger {
    public int firstMissingPositive(int[] A) {
        int i = 0;
        int n = A.length;
        while(i<n) {
            while(A[i] != (i+1) && (A[i] > 0 && A[i]<n && A[A[i]-1] != A[i])) {
                int temp = A[i];
                A[i] = A[temp-1];
                A[temp-1] = temp;
            }
            i++;
        }
        i=0;
        while(i<n) {
            if(A[i] != (i+1)) {
                return i+1;
            }
            i++;
        }
        return (n+1);
    }

    public static void main(String[] args) {
        SmallestPositiveMissingInteger obj = new SmallestPositiveMissingInteger();
        int[] A = {1,2,4,44,53,3,3};
        System.out.println(obj.firstMissingPositive(A));
    }
}
