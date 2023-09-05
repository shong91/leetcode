# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        answers = []
        def pathSum(root: Optional[TreeNode], result: List[int]) -> bool:
            if not root:
                return False

            if not root.left and not root.right:
                result.append(str(root.val))
                answers.append(int(''.join(result)))

            pathSum(root.left, result + [str(root.val)])
            pathSum(root.right, result + [str(root.val)])

        pathSum(root, [])
     
        return sum(answers)