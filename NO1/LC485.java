/**
 * Max Consecutive Ones
 * 
 * Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
 */

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        
        int max = 0;
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                max = Math.max(max, i-k+1);
            } else {
                k = i + 1;
            }
        }
        return max;
    }
}
