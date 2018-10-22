import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Min Cost to Hire K Works
 * 
 * There are N workers.  The i-th worker has a quality[i] and a minimum wage expectation wage[i].

Now we want to hire exactly K workers to form a paid group.  When hiring a group of K workers, we must pay them according to the following rules:

Every worker in the paid group should be paid in the ratio of their quality compared to other workers in the paid group.
Every worker in the paid group must be paid at least their minimum wage expectation.
Return the least amount of money needed to form a paid group satisfying the above conditions.

 

Example 1:

Input: quality = [10,20,5], wage = [70,50,30], K = 2
Output: 105.00000
Explanation: We pay 70 to 0-th worker and 35 to 2-th worker.
Example 2:

Input: quality = [3,1,10,10,1], wage = [4,8,2,2,7], K = 3
Output: 30.66667
Explanation: We pay 4 to 0-th worker, 13.33333 to 2-th and 3-th workers seperately. 
 

Note:

1 <= K <= N <= 10000, where N = quality.length = wage.length
1 <= quality[i] <= 10000
1 <= wage[i] <= 10000
Answers within 10^-5 of the correct answer will be considered correct.
 */

class Solution {
    class Node {
        int q;
        double rate;
        public Node(int q, int wage) {
            this.q = q;
            rate = wage / (double)q;
        }
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        if (quality.length == 1)    return wage[0];
        Node[] arr = new Node[quality.length];
        for (int i = 0; i < quality.length; ++i) {
            arr[i] = new Node(quality[i], wage[i]);
        }

        Arrays.sort(arr, (a,b)->{
            if (a.rate == b.rate) {
                return a.q - b.q;
            } else {
                if (a.rate < b.rate) {
                    return -1;
                } else if (a.rate > b.rate) {
                    return 1;
                } else {
                    return 0; // this is required for comparator
                }
            }
        });

        Queue<Integer> pq = new PriorityQueue<>(K, (a,b) -> b-a);
        double min = Integer.MAX_VALUE;
        int q_sum = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (pq.size() == K) {
                q_sum -= pq.poll();
            }
            q_sum += arr[i].q;
            pq.offer(arr[i].q);
            if (i >= K-1) {
                min = Math.min(min, q_sum * arr[i].rate);
            }
        }
        return min;
    }
}
