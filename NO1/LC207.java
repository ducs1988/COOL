import java.util.*;

/**
 * 207. Course Schedule
 * https://leetcode.com/problems/course-schedule/
 * 
 * There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]] 
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
 */

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List[] edges = new ArrayList[numCourses];
        int[] degree = new int[numCourses];

        for (int i = 0; i < numCourses; ++i) {
            edges[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < prerequisites.length; ++i) {
            degree[prerequisites[i][0]]++;
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        // find all indegree equal to 0 
        for (int i = 0; i < numCourses; ++i) {
            if (degree[i] == 0)
                queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int i = 0; i < edges[i].size(); ++i) {
                int prev = (int)edges[i].get(i);
                if (--degree[prev] == 0)
                    queue.offer(prev);
            }
        }

        return count == numCourses;
    }
}