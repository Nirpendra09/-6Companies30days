class Solution {
    // Function to find maximum of each subarray of size k.
    public ArrayList<Integer> max_of_subarrays(int arr[], int k) {
        // Your code here
        ArrayList<Integer> res = new ArrayList<>();
        
        int i = 0;
        int j = 0;
        int max = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        
        for(; j < k; j++) {
            pq.add(arr[j]);
        }
        
        if(pq.size() > 0) res.add(pq.peek());
        
        while(j < arr.length) {
            pq.remove(arr[i]);
            
            pq.add(arr[j]);
            res.add(pq.peek());
            i++;
            j++;
        }
        
        return res;
    }
}