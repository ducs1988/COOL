/**
 * Partition Labels
 * 
 * A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
Note:

S will have length in range [1, 500].
S will consist of lowercase letters ('a' to 'z') only.
 */

class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26]; // indicates the last position of each letter in the string
        for (int i = 0; i < s.length(); i++)
            last[s.charAt(i) - 'a'] = i;

        List<Integer> res = new ArrayList<>();
        int j = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            j = Math.max(j, last[s.charAt(i)-'a']);
            if (j == i) {
                res.add(j-start+1);
                start = i+1;
            }
        }
        return res;
    } 
}
