/**
 * 937. Reorder Log Files
 * https://leetcode.com/problems/reorder-log-files/
 * 
 * You have an array of logs.  Each log is a space delimited string of words.

For each log, the first word in each log is an alphanumeric identifier.  Then, either:

Each word after the identifier will consist only of lowercase letters, or;
Each word after the identifier will consist only of digits.
We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.

Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.

Return the final order of the logs.

 

Example 1:

Input: ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 

Note:

0 <= logs.length <= 100
3 <= logs[i].length <= 100
logs[i] is guaranteed to have an identifier, and a word after the identifier.
 */

 /**
  * Note:
  The rules are:

Letter-logs come before digit-logs;
Letter-logs are sorted alphanumerically, by content then identifier;
Digit-logs remain in the same order.

  */

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] sp1 = log1.split("\\s+", 2);
            String[] sp2 = log2.split("\\s+", 2);
            boolean isDigit1 = Character.isDigit(sp1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(sp2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                // all string
                int cmp = sp1[1].compareTo(sp2[1]);
                if (cmp != 0) 
                    return cmp;
                return sp1[0].compareTo(sp2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }
}