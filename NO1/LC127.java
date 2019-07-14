import java.util.HashSet;
import java.util.Queue;

/**
 * 127. Word Ladder
 * https://leetcode.com/problems/word-ladder/
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0)
            return 0;
        HashSet<String> wordSet = new HashSet<>();
        for (String word : wordList)
            wordSet.add(word);
        if (!wordSet.contains(endWord) || beginWord.equals(endWord))
            return 0;
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        HashSet<String> seen = new HashSet<>();
        seen.add(beginWord);
        int counts = 1;

        while (!queue.isEmpty) {
            int size = queue.size();
            counts++;
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String nextWord : getWords(word, wordSet)) {
                    if (seen.contains(nextWord))
                        continue;
                    if (nextWord.equals(endWord))
                        return counts;
                    queue.offer(nextWord);
                    seen.add(nextWord);
                }
            }
        }

        return 0;
    }

    private List<String> getWords(String s, HashSet<String> dict) {
        List<String> res = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < s.length(); i++) {
                if (c == s.charAt(i))
                    continue;
                String nextWord = replace(s, i, c);
                if (dict.contains(nextWord))
                    res.add(nextWord);
            }
        }
        return res;
    }

    private String replace(String s, int i, char c) {
        char[] chs = s.toCharArray();
        chs[i] = c;
        return new String(chs);
    }
}