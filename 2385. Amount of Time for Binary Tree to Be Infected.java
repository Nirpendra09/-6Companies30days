/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        convert(root, 0, map);

        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        int min = 0;
        Set<Integer> visited = new HashSet<>();
        visited.add(start);

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int cur = q.poll();
                for(int num : map.get(cur)) {
                    if(!visited.contains(num)) {
                        visited.add(num);
                        q.add(num);
                    }
                }
            }
            min++;
        }
        return min - 1;
    }

    public void convert(TreeNode cur, int parent, Map<Integer,Set<Integer>> map) {
        if(cur == null) return;

        if(!map.containsKey(cur.val)) {
            map.put(cur.val, new HashSet<>());
        }

        Set<Integer> adjList = map.get(cur.val);
        if(parent != 0) {
            adjList.add(parent);
        }
        if(cur.left != null) {
            adjList.add(cur.left.val);
        }
        if(cur.right != null) {
            adjList.add(cur.right.val);
        }

        convert(cur.left, cur.val, map);
        convert(cur.right, cur.val, map);
    }
}