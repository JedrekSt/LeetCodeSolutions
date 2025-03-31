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
    public ListNode swapPairs(ListNode head) {
        int i = 0;
        ListNode prev = new ListNode();
        prev.next = head;
        ListNode transformed = swap2(head,prev,i);
        return prev.next;
    }

    public ListNode swap2(ListNode head,ListNode prev, int depth){
        if (head != null){
            if(depth % 2 == 0 && head.next != null){
                ListNode next2 = swap2(head.next,head,depth + 1);
                ListNode temp = head.next;
                head.next = next2;
                temp.next = head;
                prev.next = temp;
            }
            else{
                swap2(head.next,head,depth + 1);
            }
            return head.next;
        }
        return head;
    }
}
