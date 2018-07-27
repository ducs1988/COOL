/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/

class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2)
            return;
        
        int idx = nums.length - 1;
        while (idx > 0 && nums[idx-1] >= nums[idx]) {
            idx--;    
        }
        if (idx == 0) {
            Arrays.sort(nums);
            return;
        }
        int i = nums.length - 1;
        for (; i > idx-1; i--) {
            if (nums[i] > nums[idx-1]) {
                int tmp = nums[i];
                nums[i] = nums[idx-1];
                nums[idx-1] = tmp;
                break;
            }
        }
        Arrays.sort(nums, idx, nums.length);
    }
}

/*
1. find first element from right side in position k that "nums[k] < nums[k+1]"
2. if not find in step 1, means it's a decreasing order array, sort it as increasing
3. find the fist element that greater than nums[k] from right side in range (k,length], swap
4. sort as increasing order from [k+1, end]
*/