/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]

 */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx1 = m-1;
        int idx2 = n-1;
        int last = m+n-1;
        
        while (idx2 >= 0) {
            if (idx1 < 0 || nums2[idx2] >= nums1[idx1]) {
                nums1[last--] = nums2[idx2--];
            } else {
                nums1[last--] = nums1[idx1--];
            }
        }
    }
}
 