class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0;
        int i = 0, j = 0;

        Map<Integer, Integer> map = new HashMap<>();

        long curSum = 0;
        for (; j < k; j++) {
            curSum += nums[j];
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
        }
        if (map.size() == k) {
            maxSum = curSum;
        }

        while (j < nums.length) {
            curSum -= nums[i];
            int freq = map.getOrDefault(nums[i], 0) - 1;
            if(freq <= 0) map.remove(nums[i]);
            else map.put(nums[i], freq);
            
            curSum += nums[j];
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            if (map.size() == k) {
                maxSum = Math.max(maxSum, curSum);
            }
            i++;
            j++;
        }

        return maxSum;
    }
}