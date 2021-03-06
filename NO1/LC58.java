// Length of Last word

/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Input: "Hello World"
Output: 5
*/

class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null)
            return 0;
        int count = 0, i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ')  --i;
        while (i >= 0 && s.charAt(i) != ' ') {
            ++count;
            --i;
        }
        return count;
    }
}
