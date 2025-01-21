class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int[] ans = new int[k];
        int[] index = new int[k];
        int n = nums.length, j = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        for(int i = 0; i < n; i++) {
            pq.add(new int[] {nums[i], i});
            if(pq.size() > k) {
                pq.poll();
            }
        }

        Map<Integer, Integer>  map = new HashMap<>();

        while(!pq.isEmpty()) {
            int[] temp = pq.poll();
            map.put(temp[1], temp[0]);
            index[j++] = temp[1];
        }

        Arrays.sort(index);
        for(int i = 0; i < k; i++) {
            ans[i] = map.get(index[i]);
        }

        return ans;
    }
}