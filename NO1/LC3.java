/**
 * Longest Substring Without Repeating Characters
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0, prev = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                prev = Math.max(map.get(s.charAt(i)), prev);
            }
            ans = Math.max(ans, i-prev+1);
            map.put(s.charAt(i), i+1);
        }
        return ans;
    }
}
