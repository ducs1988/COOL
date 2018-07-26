public class Solution {
	public int threeSumCloset(int[] nums, int target) {
		Arrays.sort(nums);
		int minDiff = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length - 2; i++) {
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				int diff = nums[i] + nums[left] + nums[right] - target;
				if (Math.abs(diff) < Math.abs(minDiff))
					minDiff = diff;
				if (diff == 0)
					break;
				if (diff < 0)
					left++;
				else
					right--;
			}
		}
		return target + minDiff;
	}
}