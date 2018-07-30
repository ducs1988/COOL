/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return ans;
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        help(ans, list, used, nums);
        return ans;
    }
    
    private void help(List<List<Integer>> ans, List<Integer> list, boolean[] used, int[] nums) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == true)    continue;
            if (i > 0 && nums[i] == nums[i-1] && used[i-1] == false)    continue;
            list.add(nums[i]);
            used[i] = true;
            help(ans, list, used, nums);
            used[i] = false;
            list.remove(list.size()-1);
        }
    }
}
