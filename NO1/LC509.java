/**
 * 509. Fibonacci Number
 * https://leetcode.com/problems/fibonacci-number/
 * 
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), for N > 1.
Given N, calculate F(N).
 */

class Solution {
    public int fib(int N) {
        if (N == 0) return 0;
        int first = 0, second = 1;
        for (int i = 1; i < N; i++) {
            int tmp = first + second;
            first = second;
            second = tmp;
        }
        return second;
    }
}