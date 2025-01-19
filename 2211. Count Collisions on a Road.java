class Solution {
    public int countCollisions(String directions) {
        int count = 0;
        Stack<Character> st = new Stack<>();
        st.push(directions.charAt(0));

        for(int i = 1; i < directions.length(); i++) {
            char cur = directions.charAt(i);

            if((st.peek() == 'R') && cur == 'L') {
                count += 2;
                st.pop();
                cur = 'S';
            } else if((st.peek() == 'S') && cur == 'L') {
                count += 1;
                cur = 'S';
            } 
            
            while(!st.isEmpty() && ((st.peek() == 'R' && cur == 'S'))) {
                count += 1;
                st.pop();
            }

            st.push(cur);
        }
        return count;
    }
}