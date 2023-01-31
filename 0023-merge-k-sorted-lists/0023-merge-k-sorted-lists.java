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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
      @Override
      public int compare(ListNode o1, ListNode o2) {
        return o1.val - o2.val;
      }
    });

    for (ListNode list : lists) {
        if(list != null) {
            pq.offer(list);
        }
    }

    ListNode head = new ListNode(0);
    ListNode currentNode = head;

    while (!pq.isEmpty()) {
      ListNode node = pq.poll();
      if (node.next != null) {
        pq.offer(node.next);
      }
      // swap
      currentNode.next = node;
      currentNode = currentNode.next;
    }

    return head.next;
    }
}