/**
 * 412. Fizz Buzz
 * https://leetcode.com/problems/fizz-buzz/
 */

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList();
        int i = 1;
        while (i <= n) {
            String str = "";
            if (i % 3 == 0)
                str = str + "Fizz";
            if (i % 5 == 0)
                str = str + "Buzz";
            if (str.length() == 0)
                str = String.valueOf(i);
            res.add(str);
            i++;
        }
        return res;
    }
}