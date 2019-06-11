/**
 * 72. Edit Distance
 * https://leetcode.com/problems/edit-distance/
 * 
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
 */

class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        if (n * m == 0) return n+m;
        int[][] dp = new int[n+1][m+1];
        // init
        for (int i = 0; i <= n; i++)
            dp[i][0] = i;
        for (int j = 0; j <= m; j++)
            dp[0][j] = j;
        // calc
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int left = dp[i][j-1];
                int down = dp[i-1][j];
                int corn = dp[i-1][j-1];
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    corn--;
                dp[i][j] = 1 + Math.min(left, Math.min(down, corn));
            }
        }
        // result
        return dp[n][m];
    }
}