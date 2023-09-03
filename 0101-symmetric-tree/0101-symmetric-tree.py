# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:

        def isSameTree(p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
            if p is None or q is None:
                return p == q

            return (
                p.val == q.val
                and isSameTree(p.left, q.right)
                and isSameTree(p.right, q.left)
            )
            
        return isSameTree(root.left, root.right)
