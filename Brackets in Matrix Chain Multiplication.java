class Solution {
      static class Pair {
        int cost;
        String sequence;
        
        Pair(int cost, String sequence) {
            this.cost = cost;
            this.sequence = sequence;
        }
    }
    
    static String matrixChainOrder(int arr[]) {
        // code here
        int n = arr.length;
        Pair[][] dp = new Pair[n][n];
        
        // Initialize diagonal elements (single matrices)
        for (int i = 1; i < n; i++) {
            dp[i-1][i-1] = new Pair(0, String.valueOf((char)('A' + i - 1)));
        }
        
        // Fill the table
        for (int len = 2; len <= n-1; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = new Pair(Integer.MAX_VALUE, "");
                
                for (int k = i; k < j; k++) {
                    int operations = dp[i][k].cost + dp[k+1][j].cost + 
                                   arr[i] * arr[k+1] * arr[j+1];
                                   
                    if (operations < dp[i][j].cost) {
                        dp[i][j].cost = operations;
                        dp[i][j].sequence = "(" + dp[i][k].sequence + 
                                          dp[k+1][j].sequence + ")";
                    }
                }
            }
        }
        
        return dp[0][n-2].sequence;
    }
}