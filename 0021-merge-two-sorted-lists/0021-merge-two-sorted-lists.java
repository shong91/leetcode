/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergeSort = new ListNode(-1); 
        ListNode currentNode = mergeSort; 
        
        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                currentNode.next = list2; 
                list2 = list2.next; 
            } else {
                currentNode.next = list1; 
                list1 = list1.next; 
            }
            
            currentNode = currentNode.next; 
        }
        
        // last currentNode.next
        currentNode.next = (list1 == null) ? list2 : list1; 
        
        return mergeSort.next; 
    }
    
}