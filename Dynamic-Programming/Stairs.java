public class Solution {
    
    private int[] memo;
    
    public int climbStairs(int A) {
        
        if (A < 0) return 0;
        memo = new int[A + 1];
        return steps(A);
    }
    
    private int steps(int n) {
        
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        if (memo[n] != 0) return memo[n];
        
        return steps(n - 2) + steps(n - 1);
    }
}
