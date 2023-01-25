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
      // p, q 가 모두 root value 보다 작음 -> left subtree 순회
    if (p.val < root.val && q.val < root.val) {
      return lowestCommonAncestor(root.left, p, q);

      // p, q 가 모두 root value 보다 큼 -> right subtree 순회
    } else if (p.val > root.val && q.val > root.val) {
      return lowestCommonAncestor(root.right, p, q);

      // 둘 중 하나는 크고, 하나는 작음 -> 하나는 왼쪽, 하나는 오른쪽 subtree 에 값이 존재함
      // -> 현재 루트가 LCA
    } else {
      return root;
    }
    }
}