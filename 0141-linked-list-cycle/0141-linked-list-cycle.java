/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slowPointer = head; 
        ListNode fastPointer = head; 
        
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            
            // if linked list has a cycle in it, slowPointer and fastPointer will meet
            if (slowPointer == fastPointer) {
                return true; 
            }
        }
        return false; 
        
    }
}