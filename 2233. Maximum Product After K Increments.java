class Solution {
    int MOD = (int)(1e9 + 7);
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }
        
        while(k > 0) {
            int curNum = pq.poll();
            curNum += 1;
            pq.add(curNum);
            k--;
        }
        
        long prod = 1L;
        for(int num : pq) {
            prod = (prod * num) % MOD; 
        }
        return (int)(prod % MOD);
    }
}