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
            # result.append(root.val) 는 result 의 값을 갱신함 => root-to-leaf 가 아닌 노드의 값도 계속 더해지기 때문에
            # result + [root.val] 으로 새로운 array를 인자로 넘겨줌
            hasPathSum(root.left, targetSum, result + [root.val])
            hasPathSum(root.right, targetSum, result + [root.val])
        
        hasPathSum(root, targetSum, [])
        return answer