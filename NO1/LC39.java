/*
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
*/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return ans;
        
        backtracking(ans, new ArrayList<Integer>(), 0, candidates, 0, target);
        return ans;
    }
    
    private void backtracking(List<List<Integer>> ans, List<Integer> list, int sum, int[] nums, int pos, int target) {
        if (sum == target) {
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        
        if (sum > target) return;
        
        for (int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            backtracking(ans, list, sum+nums[i], nums, i, target);
            list.remove(list.size()-1);
        }
    }
}
