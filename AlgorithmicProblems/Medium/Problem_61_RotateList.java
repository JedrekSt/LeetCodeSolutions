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

 class Wrapper{
    int length;
    ListNode node_out;

    Wrapper(int len,ListNode node){
        length = len;
        node_out = node;
    }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null){
            return head;
        }
        else{
            int i = 0;
            Wrapper wrap = get_periodic(head);
            int len = k % wrap.length;
            ListNode prev = wrap.node_out;
            ListNode iter = head;
            while(i < wrap.length - len){
                prev = iter;
                iter = iter.next;
                i += 1;
            }
            prev.next = null;
            return iter;
        }

    }

    public Wrapper get_periodic(ListNode head){
        ListNode iter = head;
        int len = 0;
        while (iter.next != null){
            len += 1;
            iter = iter.next;
        }
        iter.next = head;
        return new Wrapper(len + 1, iter);
    }
}