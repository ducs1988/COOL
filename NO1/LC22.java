/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/

public class Solution {
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		if (n == 0)	return res;
		backTracking(res, "", 0, 0, n);
		return res;
	}

	private void backTracking(List<String> list, String str, int open, int close, int max) {
		if (str.length() == 2 * max) {
			list.add(str);
			return;
		}

		if (open < max) {
			backTracking(list, str + "(", open+1, close, max);
		}

		if (close < open) {
			backTracking(list, str + ")", open, close+1, max);
		}
	}
}
