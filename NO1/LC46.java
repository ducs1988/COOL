/*
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return ans;
        List<Integer> list = new ArrayList<>();
        help(ans, list, nums);
        return ans;
    }
    
    private void help(List<List<Integer>> ans, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int n : nums) {
            if (list.contains(n))
                continue;
            list.add(n);
            help(ans, list, nums);
            list.remove(list.size()-1);
        }
    }
}
