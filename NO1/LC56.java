/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.start == b.start ? 0 : (a.start - b.start));
        List<Interval> list = new ArrayList<>();
        for (Interval interval : intervals) {
            if (list.size() == 0 || list.get(list.size()-1).end < interval.start)
                list.add(interval);
            else
                list.get(list.size()-1).end = Math.max(list.get(list.size()-1).end, interval.end);
        }
        return list;
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return intervals;
        
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0])
                    return a[0] - b[0];
                return a[1] - b[1];
            }
        });
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i-1][1] >= intervals[i][0]) {
                intervals[i][0] = intervals[i-1][0];
                intervals[i][1] = Math.max(intervals[i-1][1], intervals[i][1]);
            } else {
                list.add(intervals[i-1]);
            }
        }
        list.add(intervals[intervals.length - 1]);
        return list.toArray(new int[list.size()][]);
    }
}