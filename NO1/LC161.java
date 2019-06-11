/**
 * 161. One Edit Distance
 * https://leetcode.com/problems/one-edit-distance/
 * 
 * Given two strings s and t, determine if they are both one edit distance apart.

Note: 

There are 3 possiblities to satisify one edit distance apart:

Insert a character into s to get t
Delete a character from s to get t
Replace a character of s to get t
Example 1:

Input: s = "ab", t = "acb"
Output: true
Explanation: We can insert 'c' into s to get t.

 */

class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int slen = s.length(), tlen = t.length();
        if (slen > tlen)    return isOneEditDistance(t, s);
        if (tlen - slen > 1)    return false;

        for (int i = 0; i < slen; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (slen == tlen) {
                    return s.substring(i+1).equals(t.substring(i+1));
                } else {
                    return s.substring(i).equals(t.substring(i+1));
                }
            }
        }
        return slen + 1 == tlen;
    }
}