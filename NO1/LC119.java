/**
 * Pascal's Triangle II
 * 
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * Note that the row index starts from 0.
 * 
 * Example:
 *  Input: 3
 *  Output: [1,3,3,1]
 */

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList<>();
        prev.add(1);
        if (rowIndex < 1)   return prev;

        for (int i = 0; i < rowIndex; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);

            for (int j = 1; j < prev.size(); j++) {
                list.add(prev.get(j-1) + prev.get(j));
            }
            list.add(1);
            prev = list;
        }
        return prev;
    }
}

/**
 * Follow up:
 * Could you optimize your algorithm to use only O(k) extra space?
 * 
 * Round 1: 1 -> insert(pos, 1) that pos always = 0;
 * Round 2: 1,1 -> start @ index = 1, end @ index = length-2;
 * Round 3: 1,1,1 => set(pos=j, get(j)+get(j+1))
 *          1,2,1
 * Round 4: insert(0,1) => 1,1,2,1
 *          set values =>  1,3,3,1
 * Round 5: insert(0,1) => 1,1,3,3,1
 *          set values =>  1,4,6,4,1
 */

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for (int i = 0; i < rowIndex; i++) {
            res.add(0, 1);
            for (int j = 1; j < res.size()-1; j++) {
                res.set(0, res.get(j) + res.get(j+1));
            }
        }
        return res;
    }
}