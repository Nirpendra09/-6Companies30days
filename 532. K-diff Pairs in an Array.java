class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int key : map.keySet()) {
            if(k == 0 && map.get(key) > 1) {
                count++;
            } else if(k > 0 && map.containsKey(key + k)) {
                count++;
            }
        }

        return count;
    }
}