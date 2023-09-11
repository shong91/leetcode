# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        if not root:
            return [] 
        
        queue = deque([root])
        while queue:
            max_val = float("-inf")
            
            # BFS 처럼 만들기 - 같은 level 에 있는 노드들을 for loop 돌리며 최대값을 찾음
            for _ in range(len(queue)):
                node = queue.popleft()
                max_val = max(max_val, node.val)

                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

            res.append(max_val)

        return res
