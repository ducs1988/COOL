/**
 * Majority Elements II
 * 
 * find all elements that total count over n/3
 * 
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Note: The algorithm should run in linear time and in O(1) space.

Example 1:

Input: [3,2,3]
Output: [3]
Example 2:

Input: [1,1,1,3,3,2,2,2]
Output: [1,2]
 */

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        int na = 0, nb = 0, countA = 0, countB = 0;
        for (int num : nums) {
            if (na == num) {
                ++countA;
            } else if (nb == num) {
                ++countB;
            } else if (countA == 0) {
                na = num;
                ++countA;
            } else if (countB == 0) {
                nb = num;
                ++countB;
            } else {
                --countA;
                --countB;
            }
        }
        
        // find candidate(s) loop again make sure total count over n/3
        countA = 0;
        countB = 0;
        for (int num : nums) {
            if (na == num)
                ++countA;
            else if (nb == num)
                ++countB;
        }
        
        if (countA > nums.length / 3)
            result.add(na);
        if (na != nb && countB > nums.length / 3)
            result.add(nb);
        
        return result;
    }
}
