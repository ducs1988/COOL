/**
 * Monotonic Array
 * 
 * An array is monotonic if it is either monotone increasing or monotone decreasing.

An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].

Return true if and only if the given array A is monotonic.
 */

class Solution {
    public boolean isMonotonic(int[] A) {
        if (A == null || A.length == 1)
            return true;

        int store = 0;
        for (int i = 0; i < A.length-1; i++) {
            int c = Integer.compare(A[i], A[i+1]);
            if (c != 0) {
                if (c != store && store != 0)
                    return false;
                store = c;
            }
        }
        return true;
    }
}
