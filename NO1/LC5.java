/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
 */

class Solution {
    private int start = 0, end= 0;
    
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";
        
        for (int i = 0; i < s.length(); i++) {
            expand(s, i, i);
            expand(s, i, i+1);
        }
        
        return s.substring(start, end+1);
    }
    
    private void expand(String s, int low, int high) {
        while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
            low--;
            high++;
        }
        
        if (high - low -2 > end - start) {
            // update the answer, be careful about the index
            start = low+1;
            end = high-1;
        }
        
    }
}
