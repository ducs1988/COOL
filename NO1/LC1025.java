/**
 * 1025. Divisor Game
 * https://leetcode.com/problems/divisor-game/
 * 
 * Alice and Bob take turns playing a game, with Alice starting first.

Initially, there is a number N on the chalkboard.  On each player's turn, that player makes a move consisting of:

Choosing any x with 0 < x < N and N % x == 0.
Replacing the number N on the chalkboard with N - x.
Also, if a player cannot make a move, they lose the game.

Return True if and only if Alice wins the game, assuming both players play optimally.

 

Example 1:

Input: 2
Output: true
Explanation: Alice chooses 1, and Bob has no more moves.
 */

class Solution {
    public boolean divisorGame(int N) {
        boolean[] dp = new boolean[N+1];
        dp[0] = false;
        dp[1] = false;
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0 && dp[i-j] == false)
                    dp[i] = true;
                    break;
            }
        }
        return dp[N];
    }
}

// simple
class Solution {
    public boolean divisorGame(int N) {
        return N % 2 == 0;
    }
}