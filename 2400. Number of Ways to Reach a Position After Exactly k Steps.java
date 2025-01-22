class Solution {
    private static final int MOD = 1000000007;

    Map<String, Integer> memo;
    public int numberOfWays(int startPos, int endPos, int k) {
        memo = new HashMap<>();
        return helper(startPos, endPos, k);
    }

    private int helper(int start, int end, int k) {
        if(k == 0) {
            return start == end ? 1 : 0;
        }
        String key = start + "@" + k;
        if(memo.containsKey(key)) return memo.get(key);

        int left = helper(start - 1, end, k - 1);
        int right = helper(start + 1, end, k - 1);

        int res = (left + right) % MOD;
        memo.put(key, res);
        return res;
    }
}