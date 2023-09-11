# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findFrequentTreeSum(self, root: Optional[TreeNode]) -> List[int]:
        res = collections.defaultdict(int)

        def subTree(root: Optional[TreeNode]):
            if not root:
                return 0
            sum = root.val + subTree(root.left) + subTree(root.right)
            res[sum] += 1
            return sum
        
        subTree(root)
        frequentSum = max(res.values())
        
        # return key if its val == frequentSum
        return [k for k, v in res.items() if v == frequentSum] 