/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base condition
        if(root == null) {
            return null; 
        }
             
        if(p.val < root.val && q.val < root.val) {
            // search left sub-tree
            return lowestCommonAncestor(root.left, p, q); 
        } else if (p.val > root.val && q.val > root.val) {
            // search right sub-tree
            return lowestCommonAncestor(root.right, p, q);
        } else {
            // p.val < root.val && q.val > root.val 
            // || p.val > root.val && q.val < root.val
            // -> current root is LCA
            return root;
        }
    }
}