/**
 * Definition for singly-linked list.
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        // 마지막 노드는 null을 가리키기 때문에 null부터 시작한다
        ListNode prev = null; 

        while(head != null) {
            // head.next 를 저장해둔다 
            ListNode next = head.next; 

            // 지금 노드의 다음은 전 포인터를 가리킨다. 
            head.next = prev; 

            // 전 포인터는 지금 포인터를 가리킨다 
            prev = head; 

            // 지금 노드는 다음 포인터를 가리킨다 
            head = next; 

        }

    
    return prev; 
    }
}