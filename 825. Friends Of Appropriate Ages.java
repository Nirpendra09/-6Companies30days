class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();

        int maxLen = 0;
        int start = 0;
        int curCost = 0;

        for(int i = 0; i < n; i++) {
            curCost += Math.abs(s.charAt(i) - t.charAt(i));

            while(curCost > maxCost) {
                curCost -= Math.abs(s.charAt(start) - t.charAt(start));
                start++;
            }

            maxLen = Math.max(maxLen, i - start + 1);
        }
        
        return maxLen;
    }
}