class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(n, k, new ArrayList<>(), 1);
        return res;    
    }

    private void backtrack(int n, int k, List<Integer> cur, int start) {
        if(n == 0 && cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i = start; i <= 9; i++) {
            cur.add(i);
            backtrack(n - i, k, cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}