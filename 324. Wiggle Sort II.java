class Solution {
    public void wiggleSort(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
        Arrays.sort(nums);

        int n = nums.length;
        for(int num : nums) {
            pq.add(num);
        }

        for(int i = 1; i< n; i+= 2) {
            nums[i] = pq.poll();
        } 

        for(int i = 0; i < n; i+= 2) {
            nums[i] = pq.poll();
        }
    }
}