class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0)
            return 0;
        
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right-1];
                right--;
            } else {
                left++;
            }
        }
        return right;
    }
}
