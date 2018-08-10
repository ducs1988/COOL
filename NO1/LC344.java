/**
 * Reverse String
 * 
 * Write a function that takes a string as input and returns the string reversed.

Example 1:

Input: "hello"
Output: "olleh"
Example 2:

Input: "A man, a plan, a canal: Panama"
Output: "amanaP :lanac a ,nalp a ,nam A"
 */

class Solution {
    public String reverseString(String s) {
        if (s == null || s.length() <= 1)
            return s;
        
        int low = 0, high = s.length() - 1;
        char[] arr = s.toCharArray();
        while (low < high) {
            char ch = arr[low];
            arr[low] = arr[high];
            arr[high] = ch;
            low++;
            high--;
        }
        return new String(arr);
    }
}
