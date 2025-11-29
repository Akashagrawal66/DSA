package array;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {


    public static void main(String[] args) {
        MergeIntervals obj = new MergeIntervals();
        Interval interval1 = new Interval(1, 3);
        Interval interval2 = new Interval(6, 9);
        Interval interval4 = new Interval(10, 12);
        Interval interval3 = new Interval(2, 5);

        List<Interval> list = List.of(interval1, interval2, interval4);
        System.out.println(obj.insert(list, interval3));
    }

    private ArrayList<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int n = intervals.size();
        int start = newInterval.start;
        int end = newInterval.end;
        boolean flag = false;
        boolean elseFlag = false;
        int i = 0;
        ArrayList<Interval> ans = new ArrayList<>();
        while(i<n) {
            Interval curr = intervals.get(i);
            if(flag || end<curr.start || curr.end<start) {
                ans.add(curr);
                i++;
            } else {
                while (i<n) {
                    curr = intervals.get(i);
                    if(end >= curr.start && start<= curr.end){
                        start = Math.min(start, curr.start);
                        end = Math.max(end, curr.end);
                        i++;
                    } else {
                        ans.add(new Interval(start, end));
                        flag = true;
                        break;
                    }
                }
                if(!flag) {
                    ans.add(new Interval(start, end));
                }
                elseFlag = true;
            }
        }
        if(!elseFlag) {
            i=0;
            start = Math.min(newInterval.start, newInterval.end);
            end = Math.max(newInterval.start, newInterval.end);
            while (i<n && end >= ans.get(i).start) {
                i++;
            }
            ans.add(i, new Interval(start, end));
        }
        return ans;
    }
}
