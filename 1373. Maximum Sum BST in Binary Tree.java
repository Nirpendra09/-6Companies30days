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

class NodeValue {
    int maxVal, minVal, sum;

    NodeValue(int maxVal, int minVal, int sum) {
        this.maxVal = maxVal;
        this.minVal = minVal;
        this.sum = sum;
    }
}

class Solution {
    int max = 0;
    public int maxSumBST(TreeNode root) {
        postOrder(root);
        return max;
    }

    public NodeValue postOrder(TreeNode root) {
        if(root == null) 
            return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);

        NodeValue left = postOrder(root.left);
        NodeValue right = postOrder(root.right);

        if(left.maxVal < root.val && root.val < right.minVal) {
            int sum = left.sum + right.sum + root.val;
            max = Math.max(sum, max);
            return new NodeValue(Math.max(root.val, right.maxVal), Math.min(root.val, left.minVal), sum);
        }

        return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, Math.max(left.sum, right.sum));
    }
}