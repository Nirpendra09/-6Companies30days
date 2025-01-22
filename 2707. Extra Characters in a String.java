class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return helper(s, dictionary, 0, memo);
    }

    private int helper(String s, String[] dict, int index, int[] memo) {
        int n = s.length();
        if(index == n) return 0;

        if(memo[index] != -1) return memo[index];

        int min = Integer.MAX_VALUE;

        for(String str : dict) {
            if(index + str.length() <= n && s.substring(index, index + str.length()).equals(str) ) {
                min = Math.min(min, helper(s, dict, index + str.length(), memo));
            }
        }

        return memo[index] = Math.min(min, 1 + helper(s, dict, index + 1, memo));
    }
}