/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        if (nums == null || nums.length == 0)
            return ans;
        
        int left = expendIndex(nums, target, true);
        if (left == nums.length || nums[left] != target)
            return ans;
        
        ans[0] = left;
        ans[1] = expendIndex(nums, target, false) - 1;
        
        return ans;
    }
    
    private int expendIndex(int[] nums, int target, boolean left) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target || (left && nums[mid] == target))
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
}
