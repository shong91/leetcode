# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        # 2 pointer will meet again if it has cycle
        slow, fast = head, head

        while fast and fast.next:
            slow = slow.next # +1 step
            fast = fast.next.next # +2 step
            if slow == fast:
                return True

        return False