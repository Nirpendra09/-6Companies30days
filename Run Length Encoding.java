class Solution {
    public static String encode(String s) {
        // code here
        StringBuilder res = new StringBuilder();
        char curChar = s.charAt(0);
        int curCount = 1;
        // res.append(s.charAt(0));
        
        for(int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c != curChar) {
                res.append(curChar);
                res.append(curCount);
                curChar = c;
                curCount = 1;
            } else {
                curCount++;
            }
        }
        res.append(curChar);
        res.append(curCount);
        return res.toString();
    }
}
    