/**
 * Find Minimum in Rotated Sorted Array
 * 
 * 
 */

class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int low = 0, high = nums.length - 1;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[high])
                high = mid;
            else
                low = mid+1;
        }
        return nums[low];
    }
}
