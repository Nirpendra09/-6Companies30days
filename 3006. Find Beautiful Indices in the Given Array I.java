class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> res = new ArrayList<>();

        List<Integer> aIndices = new ArrayList<>();
        List<Integer> bIndices = new ArrayList<>();

        for(int i = 0; i <= s.length() - a.length(); i++) {
            if(s.substring(i, i + a.length()).equals(a)) {
                aIndices.add(i);
            }
        }

        for(int i = 0; i <= s.length() - b.length(); i++) {
            if(s.substring(i, i + b.length()).equals(b)) {
                bIndices.add(i);
            }
        }

        for(int i : aIndices) {
            for(int j : bIndices) {
                if(Math.abs(i - j) <= k) {
                    res.add(i);
                    break;
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}