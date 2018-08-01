/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
*/

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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> list = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            list.add(newInterval);
            return list;
        }
        
        // find insert position
        int low = 0, high = intervals.size() - 1;
        int pos = 0;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (intervals.get(mid).start < newInterval.start) 
                low = mid;
            else
                high = mid;
        }
        if (newInterval.start <= intervals.get(low).start)
            pos = low;
        else if (newInterval.start <= intervals.get(high).start)
            pos = high;
        else
            pos = high + 1;
        intervals.add(pos, newInterval);
        
        // merge intervals
        for (Interval interval : intervals) {
            if (list.size() == 0 || list.get(list.size()-1).end < interval.start)
                list.add(interval);
            else
                list.get(list.size()-1).end = Math.max(list.get(list.size()-1).end, interval.end);
        }
        return list;
    }
}
