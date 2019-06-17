/**
 * 253. Meeting Rooms II
 * https://leetcode.com/problems/meeting-rooms-ii/
 * 
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
 */

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;
        int len = intervals.length;
        int[] starts = new int[len];
        int[] ends = new int[len];
        for (int i = 0; i < len; ++i) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int iStart = 0, iEnd = 0;
        while (iStart < len) {
            if (starts[iStart] < ends[iEnd])
                iStart++;
            else {
                iStart++;
                iEnd++;
            }
        }
        return iStart - iEnd;
    }
}

