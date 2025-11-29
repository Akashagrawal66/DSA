package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals2 {
    public Interval[] merge(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(intervals2 -> intervals2.start));
        List<Interval> list = new ArrayList<>();
        int i = 1;
        int start = intervals[0].start;
        int end = intervals[0].end;
        boolean flag = false;
        while (i < intervals.length) {
            Interval curr = intervals[i];
            if (end >= curr.start && start <= curr.end) {
                start = Math.min(start, curr.start);
                end = Math.max(end, curr.end);
                flag = false;
            } else {
                flag = true;
                list.add(new Interval(start, end));
                start = curr.start;
                end = curr.end;
            }
            i++;
        }
        if (!flag) {
            list.add(new Interval(start, end));
        } else {
            list.add(intervals[intervals.length-1]);
        }
        Interval[] answer = new Interval[list.size()];
        for (i=0;i<list.size();i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        MergeIntervals2 obj = new MergeIntervals2();
        Interval i1 = new Interval(1,3);
        Interval i2 = new Interval(4,6);
        Interval i3 = new Interval(7,10);
        Interval i4 = new Interval(11,18);
        Interval[] intervals = {i1, i2, i3,i4};
        System.out.println(Arrays.toString(obj.merge(intervals)));
    }
}
