/**
 * Pascal's Triangle
 * 
 * Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0)   return res;
        res.add(new ArrayList<Integer>());
        res.get(0).add(1);
        
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            List<Integer> prev = res.get(i-1);
            
            for (int j = 1; j < prev.size(); j++) {
                list.add(prev.get(j-1) + prev.get(j));
            }
            list.add(1);
            res.add(list);
        }
        
        return res;
    }
}
