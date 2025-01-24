class Solution {
    Map<Integer, Integer> V = new HashMap<>();
    int nr, nc, rem;
    Random rand = new Random();

    public Solution(int m, int n) {
        nr = m;
        nc = n;
        rem = nr * nc;    
    }
    
    public int[] flip() {
        int r = rand.nextInt(rem--);
        int x = V.getOrDefault(r, r);
        V.put(r, V.getOrDefault(rem, rem));
        return new int[] {x / nc, x % nc};
    }
    
    public void reset() {
        V.clear();
        rem = nr * nc;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */