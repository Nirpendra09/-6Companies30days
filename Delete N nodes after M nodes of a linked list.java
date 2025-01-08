class Solution {
    static void linkdelete(Node head, int n, int m) {
        // your code here
        Node cur = head, temp;
        int count = 0;
        
        while(cur != null) {
            for(count = 1; count < m && cur != null; count++) {
                cur = cur.next;
            }
            
            if(cur == null) return;
            
            temp = cur.next;
            
            for(count = 1; count <= n && temp != null; count++) {
                temp = temp.next;
            }
            cur.next = temp;
            cur = temp;
        }
    }
}