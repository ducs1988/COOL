import java.util.HashMap;
import java.util.Map;

/**
 * 76. Minimum Window Substring
 * https://leetcode.com/problems/minimum-window-substring/
 * 
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */

class Solution {
    public String minWindow(String s, String t) {
        String res = "";
        if (s == null || s.length() == 0 || s.length() < t.length())
            return res;
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        int start = 0, i = 0, minLen = Integer.MAX_VALUE, count = 0;
        for (; i < s.length(); ++i) {
            char curt = s.charAt(i);
            if (map.containsKey(curt)) {
                map.put(curt, map.get(curt) - 1);
                if (map.get(curt) == 0)
                    ++count;
            }
            while (count == map.size()) {
                char c = s.charAt(start);
                if (map.containsKey(c)) {
                    if (map.get(c) == 0)
                        --count;
                    map.put(c, map.get(c) + 1);
                }
                if (minLen > i - start + 1) {
                    minLen = i - start + 1;
                    res = s.substring(start, i+1);
                }
                ++start;
            }
        }
        return res;
    }
}