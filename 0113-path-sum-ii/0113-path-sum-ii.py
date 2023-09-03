# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        answer = []

        def hasPathSum(root: Optional[TreeNode], targetSum: int,
            result: Optional[List[int]]
        ) -> bool:
            if not root:
                return False

            if not root.left and not root.right and targetSum == root.val:
                result.append(root.val)
                answer.append(result)

            targetSum -= root.val
            # result.append(root.val)
            hasPathSum(root.left, targetSum, result + [root.val])
            hasPathSum(root.right, targetSum, result + [root.val])
        
        hasPathSum(root, targetSum, [])
        return answer