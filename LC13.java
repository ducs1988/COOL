/**
 * Roman to Integer
 * https://leetcode.com/problems/roman-to-integer/
 * 
 */

class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        char[] sch = s.toCharArray();
        ans = toInt(sch[0]);
        for (int i = 1; i < sch.length; i++) {
            ans += toInt(sch[i]);
            if (toInt(sch[i-1]) < toInt(sch[i])) {
                ans -= (toInt(sch[i-1]) * 2);
            }
        }
        return ans;
    }
    
    private int toInt(char s) {
        switch(s) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
        }
        return 0;
    }
}