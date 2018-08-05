/**
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */

 /**
  * 因为负负得正，所以要track 当前nums[i]时候的最大值和最小值
  */

class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        
        int res = nums[0];
        int curMax = nums[0], curMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tmp = curMax;
            curMax = Math.max(nums[i], Math.max(curMax * nums[i], curMin * nums[i]));
            curMin = Math.min(nums[i], Math.min(tmp * nums[i], curMin * nums[i]));
            res = Math.max(res, curMax); 
        }

		return res;
    }
}
