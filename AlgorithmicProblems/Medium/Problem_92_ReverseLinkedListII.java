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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int i = 1;
        ListNode prev1 = null;
        ListNode iter1 = head;
        while(iter1 != null && i < left){
            prev1 = prev1 == null ? head : prev1.next;
            iter1 = iter1.next;
            i++;
        }
        ListNode new_head = reverseOrder(iter1,right,i);
        if(prev1 != null){
            prev1.next = new_head;
            return head;
        }
        return new_head;
    }

    public ListNode reverseOrder(ListNode head,int right, int i){
        if(head == null){
            return null;
        }
        ListNode iter = head.next;
        ListNode new_head = head;
        ListNode temp;
        while(i < right && iter != null){
            temp = iter.next;
            iter.next = new_head;
            new_head = iter;
            iter = temp;
            i++;
        }
        head.next = iter;
        return new_head;
    }
}