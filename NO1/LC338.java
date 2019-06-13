/**
 * 338. Counting Bits
 * https://leetcode.com/problems/counting-bits/
 * 
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example 1:

Input: 2
Output: [0,1,1]
 */

class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        for (int i = 1; i <= num; i++) {
            dp[i] = dp[i & (i-1)] + 1;
        }
        return dp;
    }
}