/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
*/

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return ans;
        
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        help(ans, list, target, 0, candidates);
        return ans;
    }
    
    private void help(List<List<Integer>> ans, List<Integer> list, int target, int pos, int[] nums) {
        if (target == 0) {
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = pos; i < nums.length; i++) {
            if (i != pos && nums[i] == nums[i-1])
                continue;
            if (target < nums[i])
                break;
            list.add(nums[i]);
            help(ans, list, target - nums[i], i+1, nums);
            list.remove(list.size()-1);
        }
    }
}
