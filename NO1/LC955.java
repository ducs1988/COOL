/**
 * 955. Delete Columns to Make Sorted II
 * https://leetcode.com/problems/delete-columns-to-make-sorted-ii/
 * 
 * We are given an array A of N lowercase letter strings, all of the same length.

Now, we may choose any set of deletion indices, and for each string, we delete all the characters in those indices.

For example, if we have an array A = ["abcdef","uvwxyz"] and deletion indices {0, 2, 3}, then the final array after deletions is ["bef","vyz"].

Suppose we chose a set of deletion indices D such that after deletions, the final array has its elements in lexicographic order (A[0] <= A[1] <= A[2] ... <= A[A.length - 1]).

Return the minimum possible value of D.length.

 

Example 1:

Input: ["ca","bb","ac"]
Output: 1
Explanation: 
After deleting the first column, A = ["a", "b", "c"].
Now A is in lexicographic order (ie. A[0] <= A[1] <= A[2]).
We require at least 1 deletion since initially A was not in lexicographic order, so the answer is 1.
 */

class Solution {
    public int minDeletionSize(String[] A) {
        if (A == null || A.length < 2)
            return 0;
        int len = A.length;
        int wide = A[0].length();
        int ans = 0;
        String[] cur = new String[len];
        for (int j = 0; j < wide; j++) {
            String[] cur2 = Arrays.copyOf(cur, len);
            for (int i = 0; i < len; i++)
                cur2[i] += A[i].charAt(j);
            if (isSorted(cur2))
                cur = cur2;
            else
                ans++;
        }
        return ans;
    }
    
    private boolean isSorted(String[] A) {
        for (int i = 1; i < A.length; i++) {
            if (A[i-1].compareTo(A[i]) > 0)
                return false;
        }
        return true;
    }
}