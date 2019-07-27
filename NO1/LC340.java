import java.util.*;

/**
 * 340. Longest Substring with At Most K Distinct Characters
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 * 
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: T is "ece" which its length is 3.
Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: T is "aa" which its length is 2.
 */

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() * k == 0)
            return 0;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        int max_len = 0;
        while (end < n) {
            map.put(s.charAt(end), end++);
            if (map.size() > k) {
                int pos = Collections.min(map.values());
                map.remove(s.charAt(pos));
                start = pos + 1;
            }
            max_len = Math.max(max_len, end - start);
        }
        return max_len;
    }
}