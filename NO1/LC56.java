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