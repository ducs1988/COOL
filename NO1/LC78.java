/**
 * Subsets
 * 
 * Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (nums == null) {
            return res;
        }
        
        if (nums.length == 0) {
            res.add(new ArrayList<Integer>());
            return res;
        }
        
        Arrays.sort(nums);
        helper(new ArrayList<Integer>(), nums, 0, res);
        return res;
    }
    
    private void helper(ArrayList<Integer> subset, int[] nums, int index, List<List<Integer>> res) {
        res.add(new ArrayList<Integer>(subset));
        
        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            helper(subset, nums, i+1, res);
            subset.remove(subset.size()-1);
        }
    }
}
