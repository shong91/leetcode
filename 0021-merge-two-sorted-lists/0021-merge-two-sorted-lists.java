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
        // compare and add on priorityqueue
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val; 
            }
        });
        
        if(list1 != null) {
            pq.offer(list1);
        }
        if(list2 != null) {
            pq.offer(list2);
        }
        
        ListNode mergeSort = new ListNode(-1); 
        ListNode currentNode = mergeSort; 
        
        while(!pq.isEmpty()) {
            ListNode node = pq.poll(); 
            if(node.next != null) {
                pq.offer(node.next); 
            }
            
            currentNode.next = node; 
            currentNode = currentNode.next; 
        }
        
        return mergeSort.next; 
    }
    
}