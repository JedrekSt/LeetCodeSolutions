/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

 class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev1 = null;
        ListNode iter2 = head;
        
        while(iter2 != null){
            if(iter2.next != null){
                if(iter2.next.val == iter2.val){
                    int ref = iter2.val;
                    while(iter2 != null){
                        if(iter2.val != ref){
                            break;
                        }
                        iter2 = iter2.next;
                    }
                    if(prev1 != null){
                        prev1.next = iter2;
                    }else{
                        head = iter2;
                    }
                    continue;
                }
                else{
                    prev1 = prev1 == null ? head : prev1.next;
                }
            }
            iter2 = iter2.next;
        }
        return head;
    }
}
