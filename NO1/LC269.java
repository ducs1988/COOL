import java.util.*;
/**
 * 269. Alien Dictionary
 * https://leetcode.com/problems/alien-dictionary/
 * 
 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

Example 1:

Input:
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]

Output: "wertf"
 */

class Solution {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0)
            return "";
        // init
        Map<Character, Integer> degree = new HashMap<>();
        Map<Character, List<Character>> edges = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!degree.containsKey(c))
                    degree.put(c, 0);
                if (!edges.containsKey(c))
                    edges.put(c, new ArrayList<Character>());
            }
        }

        // construct edges
        for (int i = 0; i < words.length - 1; ++i) {
            char[] p1 = words[i].toCharArray();
            char[] p2 = words[i+1].toCharArray();
            int pos = 0;
            while (pos < p1.length && pos < p2.length) {
                if (p1[pos] != p2[pos]) {
                    degree.put(p2[pos], degree.get(p2[pos]) + 1);
                    List<Character> list = edges.get(p1[pos]);
                    list.add(p2[pos]);
                    edges.put(p1[pos], list);
                    break;
                }
                ++pos;
            }
        }

        // sort
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for (char key : degree.keySet()) {
            if (degree.get(key) == 0)
                queue.offer(key);
        }
        while (!queue.isEmpty() && sb.length() <= degree.size()) {
            char c = queue.poll();
            sb.append(c);
            for (char ch : edges.get(c)) {
                degree.put(ch, degree.get(ch) - 1);
                if (degree.get(ch) == 0)
                    queue.offer(ch);
            }
        }

        if (sb.length() > degree.size())
            return "";
        return sb.toString();
    }
}