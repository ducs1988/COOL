/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
 */

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) set.remove(nums[i-k]);
        }
        return false;
    }
}

 /**
  * Solution:
  Intuition

Keep a sliding window of kk elements using Hash Table.

Algorithm

From the previous approaches, we know that even logarithmic performance in search is not enough. In this case, we need a data structure supporting constant time search, delete and insert operations. Hash Table is the answer. The algorithm and implementation are almost identical to Approach #2.

Loop through the array, for each element do
Search current element in the HashTable, return true if found
Put current element in the HashTable
If the size of the HashTable is larger than kk, remove the oldest item.
Return false
  */

