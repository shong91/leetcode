# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumOfLeftLeaves(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0

        # left leaf 여부 판별
        node = root.left
        if node and not node.left and not node.right:
            return node.val + self.sumOfLeftLeaves(root.right)
        else:
            # left leaf 가 아니거나, child node 가 존재함
            return self.sumOfLeftLeaves(root.left) + self.sumOfLeftLeaves(root.right)
