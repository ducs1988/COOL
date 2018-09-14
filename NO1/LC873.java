/**
 * A sequence X_1, X_2, ..., X_n is fibonacci-like if:

n >= 3
X_i + X_{i+1} = X_{i+2} for all i + 2 <= n
Given a strictly increasing array A of positive integers forming a sequence, find the length of the longest fibonacci-like subsequence of A.  If one does not exist, return 0.

(Recall that a subsequence is derived from another sequence A by deleting any number of elements (including none) from A, without changing the order of the remaining elements.  For example, [3, 5, 8] is a subsequence of [3, 4, 5, 6, 7, 8].)

 

Example 1:

Input: [1,2,3,4,5,6,7,8]
Output: 5
Explanation:
The longest subsequence that is fibonacci-like: [1,2,3,5,8].
Example 2:

Input: [1,3,7,11,12,14,18]
Output: 3
Explanation:
The longest subsequence that is fibonacci-like:
[1,11,12], [3,11,14] or [7,11,18].
 

Note:

3 <= A.length <= 1000
1 <= A[0] < A[1] < ... < A[A.length - 1] <= 10^9
(The time limit has been reduced by 50% for submissions in Java, C, and C++.)
 */

class Solution {
    public int lenLongestFibSubseq(int[] A) {
        Set<Integer> set = new HashSet();
        Map<Integer, Integer> map = new HashMap();
        for (int a : A) set.add(a);
        int N = A.length;
        int lenMax = 0;
        
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                int key = A[j] + A[i] * N;
                int curt = A[i];
                int sum = A[j] + A[i];
                int len = 0;
                while (!map.containsKey(key) && set.contains(sum)) {
                    len++;
                    map.put(key, sum);
                    int tmp = sum;
                    key = curt + sum * N;
                    sum = curt + sum;
                    curt = tmp;
                }
                if (len == 0) continue;
                lenMax = Math.max(lenMax, 2*len-(len-2));
            }
            
        }
        return lenMax;
    }
}
