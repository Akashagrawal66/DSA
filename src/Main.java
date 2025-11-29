import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[][] nums = {{0,0,0,0,0,1},{0,0,0,0,0,1},{0,0,0,0,0,1},{0,0,0,0,0,1}};
        Main m = new Main();
        System.out.println(m.findMaxOne(nums));
    }

    public int findMaxOne(int[][] nums){
        int n = nums.length;
        int m = nums[0].length;
        int i=0;
        int j=m-1;
        int max = 0;
        while(i<n && j>=0){
            if (nums[i][j] == 1) {
                max = Math.max(max, m-j);
                j--;
            } else {
                i++;
            }
        }
        return max;
    }

    public boolean findNum(int[][] nums, int k) {
        int n = nums.length;
        int m = nums[0].length;
        int i=0;
        int j=m-1;
        while(i<n && j>=0){
            if(nums[i][j] == k){
                return true;
            } else if(nums[i][j] > k) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int i=1;
        int temp = nums[0];
        int prev  = temp;
        int k=1;
        while(i<nums.length) {
            if(nums[i] == (temp+k)) {
                prev = nums[i];
                k++;
            } else if(k > 1) {
                result.add(temp+"->"+prev);
                temp = nums[i];
                prev = temp;
                k=1;
            } else {
                result.add(""+temp+"");
                prev = temp = nums[i];
            }
            i++;
        }
        if(k > 1) {
            result.add(temp+"->"+prev);
        } else {
            result.add(temp+"");
        }
        return result;
    }
}