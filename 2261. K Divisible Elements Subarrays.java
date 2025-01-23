class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        Set<List<Integer>> list = new HashSet<>();
        generateSubarray(nums, list, k, p);
        return list.size();
    }

    void generateSubarray(int[] arr, Set<List<Integer>> list, int t, int p) {
        int n = arr.length;
        int x = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                List<Integer> cur = new ArrayList<>();
                int count = 0;
                for(int k = i; k <= j; k++) {
                    if(arr[k] % p == 0) count++;
                    cur.add(arr[k]);
                }
                if(count <= t && cur.size() > 0) {
                    list.add(new ArrayList<>(cur));
                }
            }
        }
    }
}