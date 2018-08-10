/**
 * Minimum Size Subarray Sum
 * 
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example: 

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
Follow up:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 
 */

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int k = 0;
        int min = Integer.MAX_VALUE;
        int curtSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curtSum += nums[i];
            while (curtSum >= s && k <= i) {
                min = Math.min(min, i - k + 1);
                curtSum -=nums[k++];
            }
        }
        return min == Integer.MAX_VALUE? 0 : min;
    }
}
