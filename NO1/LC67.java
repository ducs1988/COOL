/**
 * Add Binary
 * 
 * Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 */

class Solution {
    public String addBinary(String a, String b) {
        if (a == null && b == null)
            return new String();
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int m = a.length()-1, n = b.length()-1;
        while (m >= 0 || n >= 0) {
            if (m >= 0) {
                carry += (int)(a.charAt(m) - '0');
                m--;
            }
            if (n >= 0) {
                carry += (int)(b.charAt(n) - '0');
                n--;
            }
            sb.insert(0, (char)(carry % 2 + '0'));
            carry /= 2;
        }
        if (carry != 0)
            sb.insert(0, '1');
        return sb.toString();
    }
}
