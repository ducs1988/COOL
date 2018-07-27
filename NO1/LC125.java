/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
*/

class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() < 2)
            return true;
        int low = 0;
        int high = s.length() - 1;
        s = s.toLowerCase();
        while (low < high) {
            while (low < high && !isValid(s.charAt(low)))   low++;
            while (low < high && !isValid(s.charAt(high)))  high--;
            if (low == high)    break;
            if (s.charAt(low++) != s.charAt(high--))
                return false;
        }
        return true;
    }
    
    private boolean isValid(char ch) {
        if ((ch >= 'a' && ch <= 'z') || (ch >= '0'&& ch <= '9'))
            return true;
        return false;
    }
}
