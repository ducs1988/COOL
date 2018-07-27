/*
Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.
Example 1:
Input: [2,2,3,4]
Output: 3
Explanation:
Valid combinations are: 
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3
*/

public class Solution {
	public int triangleNumber(int[] nums) {
		if (nums == null || nums.length < 3)
			return 0;
		int count = 0;
		Arrays.sort(nums);
		for (int i = nums.length-1; i >= 2; i--) {
			int left = 0, right = i-1;
			while (left < right) {
				if (nums[left] + nums[right] > nums[i]) {
					count += (right - left);
					right--;
				} else {
					left++;
				}
			}
		}
		return count;
	}
}