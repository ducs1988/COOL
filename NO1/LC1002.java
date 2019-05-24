/**
 * 1002. Find Common Characters
 * https://leetcode.com/problems/find-common-characters/
 * 
 * Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.

You may return the answer in any order.

 

Example 1:

Input: ["bella","label","roller"]
Output: ["e","l","l"]
 */

class Solution {
    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        int[] count = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);
        for (String str : A) {
            int[] ctTmp = new int[26];
            for (char ch : str.toCharArray())
                ctTmp[ch-'a']++;
            for (int i = 0; i < 26; i++)
                count[i] = Math.min(count[i], ctTmp[i]);
        }
        
        for (char ch = 'a'; ch <= 'z'; ch++) {
            while (count[ch - 'a']-- > 0)
                res.add("" + ch);
        }
        return res;
    }
}