class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int res = Integer.MIN_VALUE;

        int cur = 0, sum = 0;
        for(int i = 0; i < n; i++) {
            cur += (i * nums[i]);
            sum += nums[i];
        }

        res = Math.max(res, cur);
        for(int i = 1; i < n; i++) {
            cur = cur + sum - (n * nums[n - i]);
            res = Math.max(res, cur);
        }

        return res;
    }
}