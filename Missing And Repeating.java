class Solution {
    // Function to find two elements in array
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        int missing = -1;
        int repeated = -1;
       
        int n = arr.length;
        int[] hash = new int[n  + 1];
        
        for(int num : arr) {
            hash[num]++;
        }
        
        for(int i = 1; i <= n; i++) {
            if(hash[i] == 2) repeated = i;
            else if(hash[i] == 0) missing = i;
            
            if(missing != -1 && repeated != -1) break;
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        res.add(repeated);
        res.add(missing);
        return res;
    }
}
