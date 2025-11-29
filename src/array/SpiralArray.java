package array;

public class SpiralArray {
    public static void main(String[] args) {
        int[][] nums = {{0,0,0,0,0,1},{0,0,0,0,0,1},{0,0,0,0,0,1},{0,0,0,0,0,1}};
        SpiralArray array = new SpiralArray();
        array.printArraySpirally(nums);
    }

    public void printArraySpirally(int[][] nums) {
        int i = 0, j = 0;
        int c = 0;
        int n = nums.length;
        int m = nums[0].length;
        while (c < n / 2) {
            while (j < m - 1-c) {
                System.out.println(nums[i][j++]);
            }
            while (i < n - 1-c) {
                System.out.println(nums[i++][j]);
            }
            while (j > c) {
                System.out.println(nums[i][j--]);
            }
            while (i > c){
                System.out.println(nums[i--][j]);
            }
            c++;
            i = j = c;
        }
        if((n&1) == 1){
            System.out.println(nums[c][c]);
        }
    }
}
