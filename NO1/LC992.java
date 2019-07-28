import java.util.*;

/**
 * 992. Subarrays with K Different Integers
 * https://leetcode.com/problems/subarrays-with-k-different-integers/
 * 
 * Given an array A of positive integers, call a (contiguous, not necessarily
 * distinct) subarray of A good if the number of different integers in that
 * subarray is exactly K.
 * 
 * (For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.)
 * 
 * Return the number of good subarrays of A.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: A = [1,2,1,2,3], K = 2 Output: 7 Explanation: Subarrays formed with
 * exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2],
 * [1,2,1,2]. Example 2:
 * 
 * Input: A = [1,2,1,3,4], K = 3 Output: 3 Explanation: Subarrays formed with
 * exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 */

class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostK(A, K) - atMostK(A, K - 1);
    }
    
    int atMostK(int[] A, int K) {
        int n = A.length;
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        int res = 0;
        while (end < n) {
            map.put(A[end], end++);
            
            if (map.size() > K) {
                // get index needs to delete
                int pos = Collections.min(map.values());
                map.remove(A[pos]);
                start = pos + 1;
            }
            res += end - start + 1;
        }
        return res;
    }
}