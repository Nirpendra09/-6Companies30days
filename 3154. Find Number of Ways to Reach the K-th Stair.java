class Solution {
    HashMap<String, Integer> map = new HashMap<>();

    public int waysToReachStair(int k) {
        return helper(1, 0, 0, k);    
    }

    int helper(int stair, int jump, int backJump, int k) {
        String key = stair + "@" + jump + "@" + backJump;
        if(map.containsKey(key)) return map.get(key);

        int ans = 0;

        if(stair == k) ans++;

        if(stair != 0 && backJump != 1) {
            ans += helper(stair - 1, jump, 1, k);
        }

        int nextStair = stair + (1 << jump); // i + 2^jump
        if(nextStair <= k + 1) {
            ans += helper(nextStair, jump + 1, 0, k);
        }

        map.put(key, ans);
        return ans;
    }
}