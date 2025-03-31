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
    public ListNode partition(ListNode head, int x) {
        ListNode prev1 = null; // last lower than 
        
        ListNode prev2 = null;
        ListNode iter2 = head;
        
        while(iter2 != null){
            if(iter2.val < x){
                ListNode temp = iter2;
                if(prev2 == prev1){
                    prev2 = prev2 == null ? head : prev2.next;
                    iter2 = iter2.next;
                    prev1 = prev1 == null ? head : prev1.next;
                }else{
                    prev2.next = temp.next;
                    iter2 = iter2.next;
                    if(prev1 != null){
                        temp.next = prev1.next;
                        prev1.next = temp;
                        prev1 = prev1.next;
                    }else{
                        temp.next = head;
                        head = temp;
                        prev1 = head;
                    }
                }
            }else{
                prev2 = prev2 == null ? head : prev2.next;
                iter2 = iter2.next;
            }
        }
        return head;
    }
}
