/**
 * 79. Word Search
 * https://leetcode.com/problems/word-search/
 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 */

class Solution {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0)
            return true;
        if (board == null || board.length == 0)
            return false;
        
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (backtrack(board, i, j, word, 0))
                    return true;
            }
        }
        
        return false;
    }
    
    private boolean backtrack(char[][] board, int i, int j, String word, int pos) {
        if (pos == word.length())
            return true;
        if (i <0 || i >= board.length || j < 0 || j >= board[i].length)
            return false;
        if (board[i][j] != word.charAt(pos))
            return false;
        
        board[i][j] ^= 256;
        boolean res = backtrack(board, i+1, j, word, pos+1) 
            || backtrack(board, i-1, j, word, pos+1) 
            || backtrack(board, i, j+1, word, pos+1)
            || backtrack(board, i, j-1, word, pos+1);
        board[i][j] ^= 256;
        return res;
    }
}