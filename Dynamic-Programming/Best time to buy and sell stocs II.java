/*

Say you have an array, A, for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most 2 transactions.

Return the maximum possible profit.

Note: You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProfit(final List<Integer> A) {
        
        if (A == null || A.isEmpty() || A.size() == 1) return 0;
        
        int n       = A.size();
        int k       = 2;
        int[][] arr = new int[k + 1][n];
        
        for (int i = 1; i <= k; i++) {
            int maxDiff = arr[i - 1][0] - A.get(0);
            
            for (int j = 1; j < n; j++) {
                arr[i][j]   = Math.max(arr[i][j - 1], A.get(j) + maxDiff);
                maxDiff     = Math.max(maxDiff, arr[i - 1][j] - A.get(j));
            }
        }
        
        return arr[k][n - 1];
    }
}
