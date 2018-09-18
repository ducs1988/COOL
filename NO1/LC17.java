class Solution {
    String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return res;
        help(res, digits, new StringBuilder(), 0);
        return res;
    }
    
    private void help(List<String> res, String digits, StringBuilder sb, int idx) {
        if (idx == digits.length()) {
            res.add(sb.toString());
            return;
        }
        char[] arr = mapping[digits.charAt(idx)-'0'].toCharArray();
        for (char c : arr) {
            help(res, digits, sb.append(c), idx+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}