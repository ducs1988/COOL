/**
 * Intersection of two arrays
 * 
 * must unique
 */

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums1) set.add(n);
        
        Set<Integer> intersects = new HashSet<>();
        for (int n : nums2) {
            if (set.contains(n))
                intersects.add(n);
        }
        
        int[] res = new int[intersects.size()];
        int i = 0;
        for (int n : intersects) {
            res[i++] = n;
        }
        return res;
    }
}
