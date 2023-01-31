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
        // 각 연결리스트의 루트를 pq 에 저장
        if(list != null) {
            pq.offer(list);
        }
    }

    ListNode head = new ListNode(0);
    ListNode currentNode = head;

    while (!pq.isEmpty()) {
      ListNode node = pq.poll();

      // swap - 다음 노드를 currentNode 로 저장
      currentNode.next = node;
      currentNode = currentNode.next;
        
     if (node.next != null) {
        pq.offer(node.next);
      }
    }

    //Pop the smallest node and offer its next node if it is not null.
    return head.next;
    }
}