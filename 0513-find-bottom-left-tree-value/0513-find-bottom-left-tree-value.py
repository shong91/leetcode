# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findBottomLeftValue(self, root: Optional[TreeNode]) -> int:
        res = collections.defaultdict(list)

        def find(node: Optional[TreeNode], h: int):
            if node is None:
                return
            
            res[h].append(node.val)
            find(node.left, h+1)
            find(node.right, h+1)
            
        find(root, 0)
        
        left = max(res.keys())
        return res[len(res)-1][0]