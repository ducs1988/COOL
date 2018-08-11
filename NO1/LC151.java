/**
 * Reverse Words in a String
 * 
 * Given an input string, reverse the string word by word.

Example:  

Input: "the sky is blue",
Output: "blue is sky the".
Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.
 */

public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0)
            return s;
        
        String[] words = s.trim().split(" +");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0) sb.append(" ");
        }
        return sb.toString();
    }
}

/**
 * Follow up:
 * Can you only use extra O(1) space?
 * 
 * Note: the input needs to change from String to Char Array
 * Note: this solution does not trim the extra spaces
 */

public class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        int start = 0;
        for(int i = 0; i < s.length; i++){
            if(s[i] == ' '){
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }
        reverse(s, start, s.length - 1);
    }
    
    public void reverse(char[] s, int start, int end){
        while(start < end){
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }
}
 