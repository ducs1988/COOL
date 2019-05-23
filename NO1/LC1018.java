/**
 * 1018. Binary Prefix Divisible By 5
 * https://leetcode.com/problems/binary-prefix-divisible-by-5/
 * 
 * Given an array A of 0s and 1s, consider N_i: the i-th subarray from A[0] to A[i] interpreted as a binary number (from most-significant-bit to least-significant-bit.)

Return a list of booleans answer, where answer[i] is true if and only if N_i is divisible by 5.

Example 1:

Input: [0,1,1]
Output: [true,false,false]
Explanation: 
The input numbers in binary are 0, 01, 011; which are 0, 1, and 3 in base-10.  Only the first number is divisible by 5, so answer[0] is true.
 */

class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> ans = new ArrayList<>();
        if (A == null || A.length == 0)
            return ans;
        
        int num = 0;
        for (int n : A) {
            // always needs to mod by 5, in case num exceeds 32-bit integer limit
            num = (num * 2 + n) % 5;
            ans.add(num == 0);
        }
        return ans;
    }
}