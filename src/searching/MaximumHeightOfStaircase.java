package searching;

/*
Given an integer A representing the number of square blocks. The height of each square block is 1.
The task is to create a staircase of max-height using these blocks.
The first stair would require only one block, and the second stair would require two blocks, and so on.
Find and return the maximum height of the staircase.
Input 1:
    A = 10
Input 2:
    A = 20
Output 1:
    4
Output 2:
    5
*/
public class MaximumHeightOfStaircase {
    public int solve(int A) {
        int low = 0, high = A;
        while (low<=high) {
            int mid = low + (high-low)/2;
            if(((long)mid*(mid+1)) < (A* 2L)) {
                low = mid+1;
            } else if (((long)mid*(mid+1)) > (A* 2L)) {
                high = mid-1;
            } else {
                return mid;
            }
        }
        return low-1;
    }

    public static void main(String[] args) {
        MaximumHeightOfStaircase obj = new MaximumHeightOfStaircase();
        System.out.println(obj.solve((int)1e9));
    }
}
