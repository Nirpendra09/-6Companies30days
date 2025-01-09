class Solution {
    int max = 0;
    public int maxProduct(String s) {
        char[] c = s.toCharArray();
        helper(c, 0, "", "");

        return max;   
    }

    void helper(char[] c, int i, String s1, String s2) {
        if(i >= c.length) {
            if(isPalin(s1) && isPalin(s2)) {
                max = Math.max(max, s1.length() * s2.length());
            }
            return;
        }

        helper(c, i + 1, s1 + c[i], s2);
        helper(c, i + 1, s1, s2 + c[i]);
        helper(c, i + 1, s1, s2);
    }

    boolean isPalin(String s){
        int i = 0, j = s.length() - 1;
 
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
 
        return true;
    }
}