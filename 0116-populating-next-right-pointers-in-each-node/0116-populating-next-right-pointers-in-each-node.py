"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        cur, next = root, root.left if root else None

        while cur and next:
            # populating Next right pointers
            cur.left.next = cur.right
            if cur.next:
                cur.right.next = cur.next.left

            # shift cur, next
            cur = cur.next
            if not cur:
                cur = next
                next = cur.left

        return root
