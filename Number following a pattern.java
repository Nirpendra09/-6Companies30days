class Solution{
    static String printMinNumberForPattern(String S){
        // code here
        int n = S.length();
        Stack<Integer> st = new Stack<>();
        StringBuilder res = new StringBuilder();
        int num = 1;
        
        for(int i = 0; i <= n; i++) {
            st.push(num++);
            
            if(i == n || S.charAt(i) == 'I') {
                while(!st.isEmpty()) {
                    res.append(st.pop());
                }
            }
        }
        
        return res.toString();
    }
}
