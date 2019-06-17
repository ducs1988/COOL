/**
 * 252. Meeting Rooms
 * https://leetcode.com/problems/meeting-rooms/
 * 
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

Example 1:

Input: [[0,30],[5,10],[15,20]]
Output: false
 */

class Solution {
    class Interval {
        int start;
        int end;
        Interval() {start = 0; end = 0;}
        Interval(int s, int e) {start = s; end = e;}
    }
    
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return true;
        
        List<Interval> list = new ArrayList();
        for (int i = 0; i < intervals.length; i++) {
            Interval itv = new Interval(intervals[i][0], intervals[i][1]);
            list.add(itv);
        }
        Collections.sort(list, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                if (a.start == b.start)
                    return a.end - b.end;
                return a.start - b.start;
            }
        });
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i-1).end > list.get(i).start)
                return false;
        }
        return true;
    }
}
