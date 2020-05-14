/*
Given an integer A, how many structurally unique BST’s (binary search trees) exist that can store values 1…A?
*/


    public class Solution {
        public int numTrees(int A) {
           int dp[] = new int [A+2];
            dp[0] = 1;
            dp[1] = 1;
        
        for(int i=2; i<=A; i++)
        {
            for(int j=1; j<=i; j++)
            {
                dp[i] += (dp[j-1] * dp[i-j]);
            }
        }
        
        return dp[A];
        }
    }

