class Solution {
    private static int MOD = 1000000007;
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] dp = new long[n + 1];
        dp[1] = 1;

        long sharingPeople = 0;

        for(int i = 2; i <= n; i++) {
            if(i - delay >= 1) {
                sharingPeople = (sharingPeople + dp[i - delay]) % MOD;                
            }

            if(i - forget > 0) {
                sharingPeople = (sharingPeople - dp[i - forget] + MOD) % MOD;
            }

            dp[i] = sharingPeople;
        }

        long res = 0;
        for(int i = n; i > n - forget; i--) {
            res = (res + dp[i]) % MOD;
        }

        return (int)res;
    }
}