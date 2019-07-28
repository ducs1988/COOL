/**
 * 347. Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/
 * Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 */

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        
        for (int num : map.keySet()) {
            queue.add(num);
            if (queue.size() > k)
                queue.poll();
        }
        
        List<Integer> top_k = new ArrayList<>();
        while (!queue.isEmpty()) 
            top_k.add(queue.poll());
        Collections.reverse(top_k);
        return top_k;
    }
}