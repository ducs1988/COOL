/**
 * Word Break
 * 
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
 */

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0)   return true;
        Set<String> dict = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>(); // start index
        queue.offer(0);
        boolean[] visited = new boolean[s.length()]; // mark as visited start from this index
        while (!queue.isEmpty()) {
            int start = queue.poll();
            if (visited[start] == false) {
                for (int end = start+1; end <= s.length(); end++) {
                    if (dict.contains(s.substring(start,end))) {
                        queue.offer(end);
                        if (end == s.length())  return true;
                    }
                }
                visited[start] = true;
            }
        }
        return false;
    }
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Set<String> set = new HashSet(wordDict);
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
